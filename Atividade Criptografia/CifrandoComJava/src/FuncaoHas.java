import java.security.MessageDigest;

public class FuncaoHas {

	  public static void main(String[] args) throws Exception {
	        String mensagem = "SenhaSegura123";

	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(mensagem.getBytes("UTF-8"));

	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hash) {
	            String hex = Integer.toHexString(0xff & b);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        System.out.println("Hash SHA-256: " + hexString.toString());
	    }
}
