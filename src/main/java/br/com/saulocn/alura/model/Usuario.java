package br.com.saulocn.alura.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@UserDefinition
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsername() {
        return username;
    }

    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static void inserir(Usuario usuario) {
        usuario.password = BcryptUtil.bcryptHash(usuario.password);
        usuario.role = validarUserName(usuario.username);
        Usuario.persist(usuario);
    }

    private static String validarUserName(String username) {
        if (username.equals("saulocn")) {
            return "admin";
        }
        return "user";
    }

}
