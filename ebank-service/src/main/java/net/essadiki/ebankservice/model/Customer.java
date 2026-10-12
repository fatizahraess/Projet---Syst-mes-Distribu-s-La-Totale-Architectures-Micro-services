package net.essadiki.ebankservice.model;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
}