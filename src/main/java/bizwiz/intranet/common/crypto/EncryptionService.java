package bizwiz.intranet.common.crypto;
import org.jasypt.encryption.StringEncryptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EncryptionService {
    @Qualifier("jasyptStringEncryptor")
    @Autowired
    private StringEncryptor encryptor;

    public String encrypt(String plaintext) {
        return encryptor.encrypt(plaintext);
    }

    public String decrypt(String encrypted) {
        return encryptor.decrypt(encrypted);
    }
}
