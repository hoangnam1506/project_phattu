package com.example.jpaIntern.Controllers;

import com.example.jpaIntern.Models.Account;
import com.example.jpaIntern.Repositories.IAccountRepo;
import com.example.jpaIntern.Repositories.IDecentrazilationRepo;
import com.example.jpaIntern.Repositories.IUserRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Properties;

@RestController
public class AccountController {
    @Autowired
    IAccountRepo accountRepo;
    @Autowired
    IUserRepo userRepo;
    @Autowired
    IDecentrazilationRepo decentrazilationRepo;
    public static void xacThuc(String email) {
        // Địa chỉ email và mật khẩu của người gửi
        String fromEmail = "hoangnam.forworfk@gmail.com";
        String password = "blxf rxnk tgpn hekq";

        // Địa chỉ email của người nhận
        String toEmail = "recipient_email@gmail.com";

        // Cấu hình thông tin đăng nhập vào tài khoản Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo một phiên làm việc (Session)
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Tạo một đối tượng MimeMessage
            Message message = new MimeMessage(session);

            // Đặt thông tin người gửi, người nhận và nội dung email
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Test Email");
            message.setText("This is a test email sent from Java.");

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @PutMapping
    public void getTaiKhoanMoi(@RequestBody String account){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Account taikhoanMoi = gson.fromJson(account, Account.class);
        accountRepo.save(taikhoanMoi);
    }
}
