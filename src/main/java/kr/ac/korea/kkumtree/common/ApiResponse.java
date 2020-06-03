package kr.ac.korea.kkumtree.common;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private String message;
    private T data;

    private ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<T>("", data);
    }

    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<>(message, data);
    }
}
