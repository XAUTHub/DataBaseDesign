package medicines.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MedicineDao {
    void showMedicineInfo(HttpServletRequest request, HttpServletResponse response);

    void showResposity(HttpServletRequest request, HttpServletResponse response);
}
