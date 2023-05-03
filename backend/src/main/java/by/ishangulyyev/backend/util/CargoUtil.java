package by.ishangulyyev.backend.util;

import by.ishangulyyev.backend.model.CargoDTO;
import jakarta.validation.constraints.NotNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CargoUtil {
    private static final String QR_CODE_URL = "http://api.qrserver.com/v1/create-qr-code/?data=%s&size=240x240";
    public static CargoDTO mapQR(@NotNull CargoDTO cargo) {
        cargo.setQrCodeURL(String.format(QR_CODE_URL, cargo.getId()));
        return cargo;
    }
}
