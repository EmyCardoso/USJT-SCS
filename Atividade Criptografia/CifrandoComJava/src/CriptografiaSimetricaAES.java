
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class CriptografiaSimetricaAES {

	public static void main(String[] args) throws Exception {
        String textoOriginal = "Segredo123";

        // Gera uma chave AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128 bits
        SecretKey chaveSecreta = keyGen.generateKey();

        // Criptografa
        Cipher cifra = Cipher.getInstance("AES");
        cifra.init(Cipher.ENCRYPT_MODE, chaveSecreta);
        byte[] textoCriptografado = cifra.doFinal(textoOriginal.getBytes());
        String textoBase64 = Base64.getEncoder().encodeToString(textoCriptografado);
        System.out.println("Texto Criptografado (Base64): " + textoBase64);

        // Descriptografa
        cifra.init(Cipher.DECRYPT_MODE, chaveSecreta);
        byte[] textoDecodificado = Base64.getDecoder().decode(textoBase64);
        byte[] textoDescriptografado = cifra.doFinal(textoDecodificado);
        System.out.println("Texto Descriptografado: " + new String(textoDescriptografado));
    }

}
