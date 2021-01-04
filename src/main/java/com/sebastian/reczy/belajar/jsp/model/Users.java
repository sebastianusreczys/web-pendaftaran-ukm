
package com.sebastian.reczy.belajar.jsp.model;

import lombok.Data;

@Data
public class Users {
    
    private String id;
    private String nim;
    private String nama;
    private String email;
    private String jenis_kelamin;
    private Jurusan jurusan;
    private Ukm ukm;
}
