# Canvas Backend - بک‌اند Canvas

یک اپلیکیشن بک‌اند Spring Boot برای ذخیره‌ی نقاشی‌ها

## پیش‌نیازها

- Java 21
- پایگاه داده PostgreSQL
- Gradle

## راه‌اندازی

### ۱. راه‌اندازی پایگاه داده
- یک پایگاه داده PostgreSQL با نام `canvas_db` ایجاد کنید
- جزئیات اتصال پایگاه داده را در فایل `src/main/resources/application.properties` به‌روزرسانی کنید:
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/canvas_db
  spring.datasource.username={{username}}
  spring.datasource.password={{password}}
  ```

### ۲. ساخت و اجرا
```bash
./gradlew build
./gradlew bootRun
```

اپلیکیشن روی آدرس `http://localhost:8080` شروع خواهد شد.

## ساختار پروژه

```
src/main/java/org/example/canvasbe/
├── CanvasBeApplication.java         
├── controller/                       
├── service/                          
├── repository/                      
├── entity/                          
├── dto/                             
├── exception/                       
└── config/                          
```

### توضیح لایه‌ها:

#### ۱. Controller Layer (لایه کنترلر)
- مسئول مدیریت درخواست‌ها و پاسخ‌های HTTP
- تعریف endpoint های REST API

#### ۲. Service Layer (لایه سرویس)
- شامل منطق اصلی
- پردازش داده‌ها قبل از ذخیره‌سازی
- مدیریت تراکنش‌ها

#### ۳. Repository Layer (لایه مخزن)
- لایه دسترسی به داده با استفاده از Spring Data JPA
- عملیات CRUD روی پایگاه داده

#### ۴. Entity Layer (لایه موجودیت)
- موجودیت‌های JPA برای نگاشت پایگاه داده
- تعریف روابط بین جداول

#### ۵. DTO Layer (لایه انتقال داده)
- اشیاء انتقال داده برای ارتباط API
- جداسازی مدل‌های داخلی از API

## API Endpoints

### ذخیره حالت نقاشی
- **POST** `/api/canvas/save`
- **Content-Type**: `application/json`
- **بدنه درخواست**:
  ```json
  {
    "name": "drawing",
    "shapes": [
      {
        "id": "id",
        "type": "SQUARE",
        "x": 100.0,
        "y": 100.0,
        "width": 50.0,
        "height": 50.0,
        "rotation": 0.0,
        "color": "#FF0000"
      }
    ]
  }
  ```

### دریافت حالت نقاشی
- **GET** `/api/canvas/load?canvasName={name}`
- **پاسخ**: حالت نقاشی با نام مشخص شده را برمی‌گرداند

## معماری

این اپلیکیشن از معماری لایه‌ای پیروی می‌کند:

```
┌─────────────────┐
│   Controller    │ ← لایه کنترلر (مدیریت HTTP)
├─────────────────┤
│     Service     │ ← لایه سرویس (منطق کسب‌وکار)
├─────────────────┤
│   Repository    │ ← لایه مخزن (دسترسی به داده)
├─────────────────┤
│     Entity      │ ← لایه موجودیت (نگاشت پایگاه داده)
└─────────────────┘
```

## مدیریت خطا

اپلیکیشن مدیریت خطای جامعی ارائه می‌دهد:

- **۴۰۴**: حالت نقاشی یافت نشد
- **۴۰۰**: خطاهای اعتبارسنجی
- **۵۰۰**: خطاهای داخلی سرور

تمام خطاها پاسخ‌های JSON ساختاریافته با کدهای وضعیت HTTP مناسب برمی‌گردانند.

## طرح پایگاه داده

اپلیکیشن به طور خودکار جداول زیر را ایجاد می‌کند:
- `drawing_states`: ذخیره اطلاعات حالت نقاشی
- `shapes`: ذخیره اطلاعات اشکال با کلید خارجی به حالت‌های نقاشی
