package com.pgy.jwt;

import java.util.Scanner;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by admin on 14/04/2017.
 */
public class JwtLearn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        while (value != -1) {
            System.out.println("当前数字:" + value + "请继续输入数字:");
            value = new Scanner(System.in).nextInt();
        }
    }

    public static void jwtTest() {
        String secret = "password";
        String userId = "zhangsan";
        String userName = "张三";

        // 输出的jwt:eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6aGFuZ3NhbiIsInVzZXJOYW1lIjoi5byg5LiJIn0.024kCUw4nodiXEdeOWtjWFn8u2eoh-DdfmLiXYgZs9g
        String jwt = Jwts.builder().setSubject(userId).signWith(SignatureAlgorithm.HS256, secret)
            .claim("userName", userName).compact();
        System.out.println(jwt);
        // 客户端将Jwt传递给服务器,服务器根据secret进行解密,可以对jwt进行校验,取数据
        Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt);
        //header={alg=HS256},body={sub=zhangsan, userName=张三},signature=024kCUw4nodiXEdeOWtjWFn8u2eoh-DdfmLiXYgZs9g
        System.out.println(claims);
    }

}
