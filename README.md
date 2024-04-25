# CalculatorApp

Project ini merupakan aplikasi kalkulator sederhana yang akan menerima dua input angka, lalu operator yang dipilih. Terdapat beberapa validasi yang dilakukan secara berurutan yaitu:
1. nilai yang dihitung harus angka, tidak boleh karakter
2. angka yang dihitung berada pada range -32,768 hingga 32,767
3. operator yang boleh diinputkan adalah +, -, * (kali) dan / (bagi)
4. pada operasi pembagian, pembagi tidak boleh bernilai nol   
Jika validasi gagal maka sistem akan menampilkan pesan error lalu program berhenti.

Unit Testing project ini menggunakan pendekatan white box testing dengan automation testing menggunakan JUnit. Project ini dikembangkan dengan bahasa Java untuk kode program dan pembuatan script test dan Maven sebagai build tools.

## Build With
Automation Testing pada project ini menggunakan dua buah library.
 <ul>
    <li>JUnit</li>
    <li>assertion</li>
 </ul>

# Getting Started
## Pre-requisites
Sebelum menjalankan project ini, perlu disiapkan environment yang sesuai.
<ul>
 <li>Java 17+</li>
 <li>Apache Maven 3.8.0+</li>
</ul>

## Run Code
1. Clone repository dengan git
   ```
   git clone https://github.com/ameliadewi19/CalculatorApp.git
   ```
2. Buka projek melalui file explorer, lalu ketikan cmd pada kolom path
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/0d1af725-2f06-49df-a731-2ddb584b0f3d)
3. Ketikan perintah dibawah untuk membuka vscode dengan path ini
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/d03f577d-eaa3-4f77-8498-7ed8b32c5e2e)
4. Menginstall ekstensi java untuk mempermudah dalam running program
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/18aadf0d-d8e6-419d-96cf-106a77efc1cb)
5. Klik kanan pada file src>main>java>com>calculator>MainApp.java, lalu tekan Run Java
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/bd774efa-4fca-4c9c-b02b-dbff4eac89c4)
6. Masukan 2 angka yang dipisah spasi, lalu tekan enter
7. Masukan operator yaitu +, -, * atau / lalu tekan enter
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/8dce75ac-ce93-4b87-88f6-94d3ae699988)

## Struture Project Test
Berikut ini merupakan struktur kode beserta penjelasannya
```
{nama proyek}
  src
    main
      java
        com
          calculator
            Calculator.java
            Compute.java
            InputValidator.java
            MainApp.java
    test
      java
        CalculatorTest.java
        ComputeTest.java
        InputValidatorTesting.java
        MainAppTesting.java
  target
```
- package calculator berisi semua source code setiap fitur
* class Calculator berisi operasi penjumlahan, pengurangan, perkalian dan pembagian
* class Compute berisi proses yang menjalankan suatu operasi sesuai jenis operator dengan memanggil class Calculator
* class InputValidator berisi proses validasi yang terdiri dari pengecekan input operan adalah bilangan integer dan di dalam range, pengecekan operator yang valid dan pembagian dengan 0
* class MainApp merupakan main program 
- package test berisi script test dari semua fitur  

## Run Automation Test
1. Jalankan perintah berikut pada terminal
   ```
   mvn test
   ```
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/03f0ce80-ccbe-490e-bf05-29af434b5e8e)
2. Untuk melihat hasil report testing jalankan perintah berikut pada terminal
   ```
   mvn site
   ```
3. Buka hasil report pada target>site>surefire-report.html pada browser
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/c49dcf83-5395-4d8a-8a4c-776f2f881aa4)
