class MyRegex {

    // [01]?\\d{1,2} - to match numbers between 0 - 199
    // 2[0-4]\\d     - to match numbers between 200 - 249
    // 25[0-5]       - to match numbers between 250 - 255

    String zeroTo255 = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
    String pattern = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255;

//     Some valid IP Address
//            000.12.12.034
//            121.234.12.12
//            23.45.12.56

//    Some invalid IP address:
//
//            000.12.234.23.23
//            666.666.23.23
//            .213.123.23.32
//            23.45.22.32.
//            I.Am.not.an.ip
}
