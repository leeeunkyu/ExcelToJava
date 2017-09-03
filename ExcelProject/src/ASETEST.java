
public class ASETEST {
	private static final int KEY_SIZE = 128;
    private static final int ITERATION_COUNT = 10000;
    private static final String IV = "F27D5C9927726BCEFE7510B1BDD3D137";
    private static final String SALT = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
    private static final String PASSPHRASE = "passPhrase passPhrase aes encoding algorithm";
 
    private static final String PLAIN_TEXT = "AES ENCODING ALGORITHM PLAIN TEXT";    


	public static void main(String[] args) {
		   AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
	        String encrypt = util.encrypt(SALT, IV, PASSPHRASE, "TESTTTTT");
	        String decrypt = util.decrypt(SALT, IV, PASSPHRASE, encrypt);
	 
	        System.out.println("문자열 : " + "TESTTT");
	        System.out.println("암호화 : " + encrypt);
	        System.out.println("복호화 : " + decrypt); 


	}
}
