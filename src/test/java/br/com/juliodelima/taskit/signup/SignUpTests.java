package br.com.juliodelima.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@DisplayName("Testes Automatizados da Funcionalidade de Sign Up")
public class SignUpTests {
    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos() {
        // Abrir o Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        // Abra o site Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        // Clique no botão com o ID signup
        navegador.findElement(By.id("signup")).click();

        // Digite o nome do usuário no campo com ID igual a name-sign-up
        navegador.findElement(By.id("name-sign-up")).sendKeys("Aline");

        // Digite o login do usuário no campo com ID igual a login-sign-up
        navegador.findElement(By.id("login-sign-up")).sendKeys("AlineTest");

        // Digite a senha do usuário no campo com ID igual a password-sign-up
        navegador.findElement(By.id("password-sign-up")).sendKeys("123456");

        // Clique no botão com ID igual a btn-submit-sign-up
        navegador.findElement(By.id("btn-submit-sign-up")).click();

        // Validar que o texto Hi, Aline foi apresentado no elemento que possui a class igual a me
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, Aline", saudacaoAtual);

        // Feche o navegador
        navegador.quit();
    }
}

// NOW BYE!!! THANK YOU EVERYONE!