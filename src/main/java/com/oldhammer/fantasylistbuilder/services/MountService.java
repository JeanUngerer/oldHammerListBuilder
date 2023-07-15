package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.MountDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.MountMapper;
import com.oldhammer.fantasylistbuilder.models.Mount;
import com.oldhammer.fantasylistbuilder.repositories.MountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
@Transactional
public class MountService {
    MountRepository mountRepository;

    MountMapper mountMapper;

    public List<Mount> findAllMount() {
        try {
            log.info("findAllMount");
            List<Mount> mountList = new ArrayList<Mount>();
            mountRepository.findAll().forEach(ct -> mountList.add(mountMapper.entityToModel(ct)));
            return  mountList;
        } catch (Exception e) {
            log.error("We could not find all mount: " + e.getMessage());
            throw new ExceptionHandler("We could not find your mounts");
        }
    }

    public Mount findMountById(Long id) {
        try {
            log.info("findMountById - id: " + id.toString());
            Mount mount = mountMapper.entityToModel(mountRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your mount")));
            return mount;
        } catch (Exception e) {
            log.error("We could not find all mount: " + e.getMessage());
            throw new ExceptionHandler("We could not find your mount");
        }
    }

    public Mount createMount(MountDTO dto) {
        try {
            log.info("createMount");
            Mount mount = mountMapper.dtoToModel(dto);
            mountRepository.save(mountMapper.modelToEntity(mount));
            return mount;
        } catch (Exception e) {
            log.error("Couldn't mount user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your mount");
        }
    }
    public Mount updateMount(MountDTO dto) {
        try {
            log.info("updateMount - id: " + dto.getId().toString());
            Mount mount = mountMapper.entityToModel(mountRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your mount")));
            mountMapper.updateFromDto(dto, mount, new CycleAvoidingMappingContext());
            mountRepository.save(mountMapper.modelToEntity(mount));
            return mount;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your mount");
        }
    }

    public String deleteMount(Long id) {
        try {
            log.info("deleteMount - id: " + id.toString());
            Mount mount = mountMapper.entityToModel(mountRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your mount")));
            mountRepository.delete(mountMapper.modelToEntity(mount));
            return "Mount deleted";
        } catch (Exception e) {
            log.error("Couldn't delete mount: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your mount");
        }
    }
}
