package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl {

    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = new TeacherMapper();
    }

    public TeacherDTO findOne(Integer id) {
        return teacherMapper.transformToDTO(teacherRepository.getOne(id));
    }

    public List<TeacherDTO> findAll() {
        List<TeacherDTO> retval = new ArrayList<>();
        teacherRepository.findAll().forEach((teacher) -> retval.add(teacherMapper.transformToDTO(teacher)));

        return retval;
    }

    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.save(teacherMapper.transformToEntity(teacherDTO));
        return teacherMapper.transformToDTO(teacher);
    }

    public void remove(Integer id) throws IllegalArgumentException {
    }

    public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
        return null;
    }

    public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
        return teacherMapper.transformToDTO(
                teacherRepository.findByTeacherNameAndTeacherSurname(name, surname).orElse(null)
        );
    }

    public TeacherDTO findByTeacherEmail(String email) {
        return teacherMapper.transformToDTO(teacherRepository.findByTeacherEmail(email).orElse(null));
    }
}
