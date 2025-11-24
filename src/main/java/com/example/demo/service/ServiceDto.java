package com.example.demo.service;

import com.example.demo.DTO.ProjetDetailDTo;

import java.time.format.DateTimeFormatter;

public class ServiceDto {
    public ProjetDetailDTo getDetailProjet(Long id) {
        ProjetDetailDTo detail = projetDetailRepository.findBy(id).orElseThrow(() -> new RuntimeException(("Details du projet non trouves"));
        return convertToDto(detail);}
    private ProjetDetailDTo convertToDto(ProjetDetailDTo detail) {
        ProjetDetailDTo dto = new ProjetDetailDTo();
        dto.setDescription(detail.getDescription());
        dto.setTechnologie(detail.getTechnologie());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dto.setDateDebut(detail.getDateDebut().format(formatter));
        return dto;


    }
}
