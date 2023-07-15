package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.MagicDomainDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.MagicDomainMapper;
import com.oldhammer.fantasylistbuilder.models.MagicDomain;
import com.oldhammer.fantasylistbuilder.repositories.MagicDomainRepository;
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
public class MagicDomainService {
    MagicDomainRepository magicDomainRepository;

    MagicDomainMapper magicDomainMapper;

    public List<MagicDomain> findAllMagicDomain() {
        try {
            log.info("findAllMagicDomain");
            List<MagicDomain> magicDomainList = new ArrayList<MagicDomain>();
            magicDomainRepository.findAll().forEach(ct -> magicDomainList.add(magicDomainMapper.entityToModel(ct)));
            return  magicDomainList;
        } catch (Exception e) {
            log.error("We could not find all magicDomain: " + e.getMessage());
            throw new ExceptionHandler("We could not find your magicDomains");
        }
    }

    public MagicDomain findMagicDomainById(Long id) {
        try {
            log.info("findMagicDomainById - id: " + id.toString());
            MagicDomain magicDomain = magicDomainMapper.entityToModel(magicDomainRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your magicDomain")));
            return magicDomain;
        } catch (Exception e) {
            log.error("We could not find all magicDomain: " + e.getMessage());
            throw new ExceptionHandler("We could not find your magicDomain");
        }
    }

    public MagicDomain createMagicDomain(MagicDomainDTO dto) {
        try {
            log.info("createMagicDomain");
            MagicDomain magicDomain = magicDomainMapper.dtoToModel(dto);
            magicDomainRepository.save(magicDomainMapper.modelToEntity(magicDomain));
            return magicDomain;
        } catch (Exception e) {
            log.error("Couldn't magicDomain user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your magicDomain");
        }
    }
    public MagicDomain updateMagicDomain(MagicDomainDTO dto) {
        try {
            log.info("updateMagicDomain - id: " + dto.getId().toString());
            MagicDomain magicDomain = magicDomainMapper.entityToModel(magicDomainRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your magicDomain")));
            magicDomainMapper.updateFromDto(dto, magicDomain, new CycleAvoidingMappingContext());
            magicDomainRepository.save(magicDomainMapper.modelToEntity(magicDomain));
            return magicDomain;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your magicDomain");
        }
    }

    public String deleteMagicDomain(Long id) {
        try {
            log.info("deleteMagicDomain - id: " + id.toString());
            MagicDomain magicDomain = magicDomainMapper.entityToModel(magicDomainRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your magicDomain")));
            magicDomainRepository.delete(magicDomainMapper.modelToEntity(magicDomain));
            return "MagicDomain deleted";
        } catch (Exception e) {
            log.error("Couldn't delete magicDomain: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your magicDomain");
        }
    }
}
