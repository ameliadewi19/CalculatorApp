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
        InputValidatorTest.java
        MainAppTest.java
  target
```
- package calculator berisi semua source code setiap fitur
- class Calculator berisi operasi penjumlahan, pengurangan, perkalian dan pembagian
- class Compute berisi proses yang menjalankan suatu operasi sesuai jenis operator dengan memanggil class Calculator
- class InputValidator berisi proses validasi yang terdiri dari pengecekan input operan adalah bilangan integer dan di dalam range, pengecekan operator yang valid dan pembagian dengan 0
- class MainApp merupakan main program 
- package test berisi script test dari semua fitur  

## Run Automation Test
1. Jalankan perintah berikut pada terminal untuk menjalankan semua test
   ```
   mvn test
   ```
   Berikut merupakan hasil dari perintah di atas
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95154453/5070c0de-f45c-4b63-8ae9-415f64d51076)

   Untuk menjalankan test pada satu class test saja, jalankan perintah berikut
   ```
   mvn test -Dtest=NamaFileTest
   ```
   Berikut merupakan hasil dari perintah di atas
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95154453/2220c268-93e4-4a45-9ea7-872867e08434)

   Untuk menjalankan satu method test saja, jalankan perintah berikut
   ```
   mvn test -Dtest=NamaFileTest#NamaMethod
   ```
   Berikut merupakan hasil dari perintah di atas
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95154453/51848381-3e52-424c-8eb2-21140fdb0bd0)

3. Untuk melihat hasil report testing jalankan perintah berikut pada terminal
   ```
   mvn site
   ```
4. Buka hasil report pada target>site>surefire-report.html pada browser
   ![image](https://github.com/ameliadewi19/CalculatorApp/assets/95133748/c49dcf83-5395-4d8a-8a4c-776f2f881aa4)

## Test Cases
Pembuatan test case meliputi test positif dan negatif untuk setiap modul yang ada di tiap class. Pengujian unit testing ini menggunakan teknik white box testing dengan metode path testing untuk setiap modul.

#### MainAppTest.java
```
1. Pemeriksaan kondisi input 1 buah operand angka dan 1 buah operand huruf
2. Pemeriksaan kondisi input 1 buah operand angka dan 1 buah operand karakter khusus/simbol
3. Pemeriksaan kondisi input 1 buah operand angka dalam range integer dan 1 buah operand angka dibawah batas bawah range integer
4. Pemeriksaan kondisi input 1 buah operand angka dalam range integer dan 1 buah operand angka diatas batas atas range integer
5. Pemeriksaan kondisi input operand valid dan operator karakter khusus selain (+, -, /, *)
6. Pemeriksaan kondisi input operand valid dan operator selain karakter khusus
7. Pemeriksaan kondisi input operand valid dan operator valid 
```
#### InputValidatorTest.java
```
1. Pemeriksaan nilai operand integer
2. Pemeriksaan nilai operand selain integer
3. Pemeriksaan nilai operand di bawah batas bawah nilai integer
4. Pemeriksaan nilai operand di atas batas atas nilai integer
5. Pemeriksaan nilai operand di dalam range nilai integer
6. Pemeriksaan nilai operator yang sesuai (+, -, /, *)
7. Pemeriksaan nilai operator yang tidak sesuai (+, -, /, *)
8. Pemeriksaan pembagian dengan bilangan 0
9. Pemeriksaan pembagian dengan bilangan bukan 0
```
#### ComputeTest.java
```
1. Pemeriksaan kondisi input penyebut 0 untuk operator pembagian
2. Pemeriksaan kondisi operator penjumlahan
3. Pemeriksaan kondisi operator pengurangan
4. Pemeriksaan kondisi operator perkalian
5. Pemeriksaan kondisi operator pembagian dengan penyebut > 0
```
#### CalculatorTest.java
```
1. Pemeriksaan hasil operasi tambah
2. Pemeriksaan hasil operasi kurang
3. Pemeriksaan hasil operasi kali
4. Pemeriksaan hasil operasi bagi
```

## Author
[Amelia Dewi Agustiani](https://github.com/ameliadewi19) (211524002)

[Salsabila Maharani Putri](https://github.com/salsabilamp3) (211524026)

_Mahasiswa D4 Teknik Informatika Politeknik Negeri Bandung_
