package tests;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest {
    public static void main(String[] args) {
        // Mở trang Google
        open("https://www.google.com");

        // Nhập từ khóa vào ô tìm kiếm và nhấn Enter
        $("[name='q']").setValue("Selenide").pressEnter();

        // Kiểm tra kết quả đầu tiên có chứa từ khóa "Selenide"
        $$("h3").first().shouldHave(text("Selenide"));

        // Đóng trình duyệt
        closeWebDriver();
    }
}
