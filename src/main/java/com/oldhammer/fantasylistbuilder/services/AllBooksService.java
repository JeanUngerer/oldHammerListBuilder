package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.AllBooksDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.AllBooksMapper;
import com.oldhammer.fantasylistbuilder.models.AllBooks;
import com.oldhammer.fantasylistbuilder.repositories.AllBooksRepository;
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
public class AllBooksService {
    AllBooksRepository allBooksRepository;
    
    AllBooksMapper allBooksMapper;

    public List<AllBooks> findAllAllBooks() {
        try {
            log.info("findAllAllBooks");
            List<AllBooks> allBooksList = new ArrayList<AllBooks>();
            allBooksRepository.findAll().forEach(ct -> allBooksList.add(allBooksMapper.entityToModel(ct)));
            return  allBooksList;
        } catch (Exception e) {
            log.error("We could not find all allBooks: " + e.getMessage());
            throw new ExceptionHandler("We could not find your allBookss");
        }
    }

    public AllBooks findAllBooksById(Long id) {
        try {
            log.info("findAllBooksById - id: " + id.toString());
            AllBooks allBooks = allBooksMapper.entityToModel(allBooksRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your allBooks")));
            return allBooks;
        } catch (Exception e) {
            log.error("We could not find all allBooks: " + e.getMessage());
            throw new ExceptionHandler("We could not find your allBooks");
        }
    }

    public AllBooks createAllBooks(AllBooksDTO dto) {
        try {
            log.info("createAllBooks");
            AllBooks allBooks = allBooksMapper.dtoToModel(dto);
            allBooksRepository.save(allBooksMapper.modelToEntity(allBooks));
            return allBooks;
        } catch (Exception e) {
            log.error("Couldn't allBooks user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your allBooks");
        }
    }
    public AllBooks updateAllBooks(AllBooksDTO dto) {
        try {
            log.info("updateAllBooks - id: " + dto.getId().toString());
            AllBooks allBooks = allBooksMapper.entityToModel(allBooksRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your allBooks")));
            allBooksMapper.updateFromDto(dto, allBooks, new CycleAvoidingMappingContext());
            allBooksRepository.save(allBooksMapper.modelToEntity(allBooks));
            return allBooks;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your allBooks");
        }
    }

    public String deleteAllBooks(Long id) {
        try {
            log.info("deleteAllBooks - id: " + id.toString());
            AllBooks allBooks = allBooksMapper.entityToModel(allBooksRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your allBooks")));
            allBooksRepository.delete(allBooksMapper.modelToEntity(allBooks));
            return "AllBooks deleted";
        } catch (Exception e) {
            log.error("Couldn't delete allBooks: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your allBooks");
        }
    }
}
