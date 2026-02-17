package com.study.profile_stack_api.domain.profile.service;

import com.study.profile_stack_api.domain.profile.dto.response.ProfileResponse;
import com.study.profile_stack_api.domain.profile.entity.Profile;
import com.study.profile_stack_api.domain.profile.repository.dao.ProfileDao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    // ProfileDao 인터페이스로 컨트롤
    private final ProfileDao repository;
    // IoC에 의한 종속성 주입
    public ProfileService(ProfileDao profileDao) {this.repository = profileDao;}

    // === Create ===

    // === Read ===
    public ProfileResponse getProfileById(Long id) {
        Optional<Profile> result = repository.findById(id);
        Profile profile = result.orElseThrow(() -> new RuntimeException("Profile not found"));
        return ProfileResponse.from(profile);
    }

    // === Update ===

    // === Delete ===

}
