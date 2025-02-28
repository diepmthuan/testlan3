package poly.edu.service;

import java.util.List;


import poly.edu.entity.AccountEntity;

public interface AccountService {
    AccountEntity findByUsername(String username);  // Tìm tài khoản theo username
    AccountEntity findById(String username);  // Tìm tài khoản theo ID
    List<AccountEntity> findAll();  // Lấy danh sách tất cả tài khoản
    void save(AccountEntity account);  // Lưu hoặc cập nhật tài khoản
    void deleteById(String username);  // Xóa tài khoản theo ID
    boolean existsByUsername(String username);  // Kiểm tra username có tồn tại không
}
