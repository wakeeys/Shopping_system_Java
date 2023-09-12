package javaproject.control;

public interface SecretControl {
    public void modifySecret(String name, String newSecret) throws Exception;
    public int resetSecret(String userName, String userSecret) throws Exception;
}
