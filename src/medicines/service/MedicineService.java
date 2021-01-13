package medicines.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MedicineService {
    void showMedicineInfo(HttpServletRequest request, HttpServletResponse response);

    void login(HttpServletRequest request, HttpServletResponse response);

    void showResposity(HttpServletRequest request, HttpServletResponse response);

    void showFactory(HttpServletRequest request, HttpServletResponse response);

    void showIn(HttpServletRequest request, HttpServletResponse response);

    void showOut(HttpServletRequest request, HttpServletResponse response);

    void showInMore(HttpServletRequest request, HttpServletResponse response);

    void showOutMore(HttpServletRequest request, HttpServletResponse response);

    void showClient(HttpServletRequest request, HttpServletResponse response);
}
