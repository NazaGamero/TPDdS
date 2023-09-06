package dds.grupo3.clases.notificaciones;

public class MailSender {
//    public static void sendMail(String destinatario, String texto){
//      Properties prop = new Properties();
//      prop.put("mail.smtp.auth", true);
//      prop.put("mail.smtp.starttls.enable", "true");
//      prop.put("mail.smtp.host", "smtp.gmail.com");
//      prop.put("mail.smtp.port", "587");
//
//      String remitente = "mihuellaapp2022@gmail.com";
//      String password = "zxcnzdxudkgljanm";
//
//      Session session = Session.getInstance(prop, new Authenticator() {
//        @Override
//        protected PasswordAuthentication getPasswordAuthentication() {
//          return new PasswordAuthentication(remitente, password);
//        }
//      });
//      Message message = prepareMessage(session,remitente,destinatario,texto);
//      try {
//        Transport.send(message);
//      } catch (MessagingException e) {
//        e.printStackTrace();
//      }
//    }
//
//    private static Message prepareMessage(Session session, String myAccount,String recipient,String texto) {
//      try {
//        Message message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(myAccount));
//        message.setRecipients(
//            Message.RecipientType.TO, InternetAddress.parse(recipient));
//        message.setSubject("Notificacion Mi Huella App");
//        message.setText(texto);
//        return message;
//      }
//      catch (Exception exception){
//        Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE,null,exception);
//      }
//      return null;
//    }
}