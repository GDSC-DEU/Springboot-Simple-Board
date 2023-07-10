package com.gdscdeu.springboot.simpleboard.Services;

import com.gdscdeu.springboot.simpleboard.DTOs.FindPostsDto;
import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import com.gdscdeu.springboot.simpleboard.Repositorys.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateService {
    @Autowired //의존성 주입
    UpdateRepository updateRepository;

    @Transactional //매칭한 메서드를 하나의 트랜젝션으로 묶는 역할
    public Posts save(FindPostsDto requestDto) {
        return updateRepository.save(requestDto.toEntity());
    }

    @Transactional
    public Posts update(Long id, FindPostsDto requestDto) {
        Posts entity = updateRepository.findById(id)// id에 해당하는 게시글을 검색, Optional<Posts> 반환
                .orElseThrow(() -> new IllegalArgumentException()); //Optional 객체에 값이 존재하는 경우 해당 값을 반환하고, 값이 없는 경우 IllegalArgumentException 예외를 발생
        if (requestDto.getTitle() != null) {
            entity.setTitle(requestDto.getTitle());
        }
        if (requestDto.getContent() != null) {
            entity.setContent(requestDto.getContent());
        }
        //entity.update(requestDto.getTitle(), requestDto.getContent());

        return updateRepository.save(entity);
    }

}
