import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class CriptografiaAssimetricaRSA {

	 public static void main(String[] args) throws Exception {
	        String mensagem = "Mensagem Secreta";

	        // Geração do par de chaves RSA
	        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	        keyGen.initialize(2048);
	        KeyPair parChaves = keyGen.generateKeyPair();
	        PublicKey chavePublica = parChaves.getPublic();
	        PrivateKey chavePrivada = parChaves.getPrivate();

	        // Criptografa com chave pública
	        Cipher cifra = Cipher.getInstance("RSA");
	        cifra.init(Cipher.ENCRYPT_MODE, chavePublica);
	        byte[] mensagemCriptografada = cifra.doFinal(mensagem.getBytes());
	        String criptografadaBase64 = Base64.getEncoder().encodeToString(mensagemCriptografada);
	        System.out.println("Criptografado (Base64): " + criptografadaBase64);

	        // Descriptografa com chave privada
	        cifra.init(Cipher.DECRYPT_MODE, chavePrivada);
	        byte[] bytesDecodificados = Base64.getDecoder().decode(criptografadaBase64);
	        byte[] mensagemDescriptografada = cifra.doFinal(bytesDecodificados);
	        System.out.println("Descriptografado: " + new String(mensagemDescriptografada));
	    }
}
