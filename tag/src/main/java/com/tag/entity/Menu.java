package com.tag.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class Menu {
    @Id
    private Long id;
    private String menu;
    @Column(name = "sub_menu")
    private String subMenu;

    @Builder
    public Menu(Long id, String menu, String subMenu) {
        this.id = id;
        this.menu = menu;
        this.subMenu = subMenu;
    }
}
