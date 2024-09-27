package com.javabackendakademisi.freelancerMatchingPlatform.service;


import com.javabackendakademisi.freelancerMatchingPlatform.exception.ResourceNotFoundException;
import com.javabackendakademisi.freelancerMatchingPlatform.exception.ValidationException;
import com.javabackendakademisi.freelancerMatchingPlatform.model.Dress;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Elbise servisi
@Service
public class DressService {
    private final DressRepository dressRepository;

    @Autowired
    public DressService(DressRepository dressRepository) {
        this.dressRepository = dressRepository;
    }

    // Elbise ekleme
    public Dress addDress(Dress dress) {
        dressRepository.save(dress);
        return dress;
    }

    // Tüm elbiseleri listeleme
    public List<Dress> getAllDresses() {
        return dressRepository.findAll();
    }

    // Elbise kiralama
    public Dress rentDress(Long id) {
        Dress dress = dressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dress not found with id: " + id));
        if (!dress.isAvailable()) {
            throw new ValidationException("Dress is not available for rent.");
        }
        dress.setAvailable(false);
        dressRepository.save(dress);
        return dress;
    }
}