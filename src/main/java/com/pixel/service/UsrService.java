package com.pixel.service;

import com.pixel.model.Usr;
import com.pixel.repository.UserRepository;
import com.pixel.repository.UsrRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class UsrService {

    @Autowired
    private UsrRepository usrRepository;

    Object target;
    Logger logger = LoggerFactory.getLogger(UsrService.class);
    @Autowired
    private UsrRepository userRepository;

    public CompletableFuture<List<Usr>> saveCsvUsers(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<Usr> users=parseCSVFile(file);
        logger.info("saving List of users of size{}",users.size()," " + Thread.currentThread().getName());
        users = usrRepository.saveAll(users);
        long end = System.currentTimeMillis();
        logger.info("Total time {}", end-start);
        return CompletableFuture.completedFuture(users);
    }
    @Async
    public CompletableFuture<List<Usr>> findAllUsers(){
        logger.info("get list of user by "+Thread.currentThread().getName());
        List<Usr> users=userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }
    private List<Usr> parseCSVFile(final MultipartFile file) throws Exception {
        final List<Usr> users = new ArrayList<>();
        try {
            try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                String line;
                while((line = br.readLine()) != null){
                    final String[] data = line.split(",");
                    final Usr usr = new Usr();
                    usr.setName(data[0]);
                    usr.setEmail(data[1]);
                    usr.setGender(data[2]);
                    users.add(usr);
                }
                return users;
            }
        } catch (final IOException e) {
            logger.error("failed to parse CSV file {}",e);
            throw  new Exception("Failed to parse CSV file {}", e);
        }
    }

}
