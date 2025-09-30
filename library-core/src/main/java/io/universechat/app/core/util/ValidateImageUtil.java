package io.universechat.app.core.util;

import jakarta.inject.Singleton;

@Singleton
public class ValidateImageUtil {

    public static boolean isImageFile(String contentType) {
        return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
    }
}
