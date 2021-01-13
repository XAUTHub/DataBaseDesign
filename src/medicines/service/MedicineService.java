package medicines.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MedicineService {
    void showMedicineInfo(HttpServletRequest request, HttpServletResponse response);

    void login(HttpServletRequest request, HttpServletResponse response);

    void showResposity(HttpServletRequest request, HttpServletResponse response);
}
