package uz.gita.testappmvp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.gita.testappmvp.model.TestData;

public class AppRepository {
    private List<TestData> dataList;
    private static AppRepository repository;

    public static AppRepository getInstance() {
        if (repository == null) repository = new AppRepository();
        return repository;
    }

    private AppRepository() {
        loadTests();
    }

    private void loadTests() {
        dataList = new ArrayList<>();
        dataList.add(new TestData("U Geyms Kukda kichkina, Arnold Shvartsnegrda katta, Madonna va Kleopatrada umuman yo’q, Rim papasida bor, lekin uni ishlatmaydi. Gap nima haqida ketyapti?", "Ism", "Familiya", "Otasining ismi", "To'g'ri javob yo'q.", "Familiya"));
        dataList.add(new TestData("Finlyandiya, Nоrvegiya, Shvetsiyada yangi yil kuni uni sоvg’a qilishsa bilingki, sizga baxt va iliqlik istashayоtgan bõladi. Yunоnistоn va Ispaniyada u havf-xatar belgisi bõlgan. Haqiqatdan ham undan katta xavf bõlishi mumkin. Savоl u nima?", "Soat", "Ro'molcha", "Pichoq", "To'g'ri javob yo'q", "To'g'ri javob yo'q"));
        dataList.add(new TestData("Tizza bo’g’imlari 4 ta bo’lgan yagona sutemizuvchi hayvon qaysi?", "Fil", "Ilon", "Baliq", "Sichqon", "Fil"));
        dataList.add(new TestData("U eng arzon va eng qimmat mulk. Undan to’g’ri foydalanilsa dahoga aylanish mumkin. U nima?", "Telefon", "Kompyuter", "Vaqt", "Mashina", "Vaqt"));
        dataList.add(new TestData("Undan qanchalik ko’p olaversangiz, u shunchalik kattalashib boraveradi. U nima?", "Ism", "Chuqur", "Nafas", "Pul", "Chuqur"));
        dataList.add(new TestData("Kichkina, kulranggina, filga o’xshaydi.", "Fil", "Sichqon", "Filning bolasi", "Mushuk", "Filning bolasi"));
        dataList.add(new TestData("Merining otasining beshta qizi bor. Ularning ismlari Chacha, Cheche, Chichi, Chocho… Beshinchi qizining ismi nima bo’lishi mumkin?", "To'g'ri javob yo'q", "Chichi", "Chacha", "Meri", "Meri"));
        dataList.add(new TestData("Qaysi inson otni ham, filni ham hech bir qiyinchiliksiz ko’tarishga, ularni joyini o’zgartirishga qodir?", "Bokschi", "To'g'ri javob yo'q", "Prezident", "Chavandoz", "To'g'ri javob yo'q"));
        dataList.add(new TestData("Kishiga uch marta beriladi: birinchi ikki marta bepul, ammo uchinchi marta yoki undan keyin pul to’lash kerak bo’ladi. U nima?", "Tish", "Sumka", "Mehr", "Suv", "Tish"));
        dataList.add(new TestData("Qaysi yegulikni pishirishda qancha tuz solsa ham, u sho’r bo’lib ketmaydi?", "Non", "Qaynatilgan tuxumni", "Osh", "To'g'ri javob yo'q", "Qaynatilgan tuxumni"));
        dataList.add(new TestData("O’rdaklar suv ichishga qator bo’lib ketayotgan edi. O’rdaklardan biri oldinga qarab, 17 ta boshni ko’rdi. Ortiga qarasa — 42 ta panja kelayotgan ekan. Jami nechta o’rdak suv ichishga ketmoqda?", "39", "21", "17", "42", "39"));
        dataList.add(new TestData("Choyni qaysi qo’l bilan aralashtirish kerak?", "Chap", "To'g'ri javob yo'q", "Qoshiqcha bilan", "O'ng", "Qoshiqcha bilan"));
        dataList.add(new TestData("U sizga tegishli, ammo boshqalar undan sizga nisbatan ancha ko’proq foydalanishadi. U nima?", "Mashina", "To'g'ri javob yo'q", "O'zim", "Ism", "Ism"));
        dataList.add(new TestData("Stolning 4 ta burchagi bor. Shu burchaklardan birini kesib olib tashlasa, unda nechta burchak qoladi?", "8ta", "Burchak qolmaydi", "5ta", "To'g'ri javob yo'q", "5ta"));
        dataList.add(new TestData("Nimaning 40 qulochi 1 gramga teng?", "Havo", "Ip", "Paxta", "To'g'ri javob yo'q", "Ip"));
        dataList.add(new TestData("Qaysi qizning otasi yo’q, onasi yo’q – bobosi bor?", "Qorqiz", "Oppoq oy", "Qizil shapkacha", "Zuxra", "Qorqiz"));
        dataList.add(new TestData("Qanday soat sutkada ikki marta aniq vaqtni ko'rsatadi?", "BigBen", "Buzuq soat", "To'g'ri javob yo'q", "Qo'l soat", "Buzuq soat"));
        dataList.add(new TestData("Daraxtning 4 ta shoxi bor, har bir shoxida yana 4 tadan shoxchalari bor, bu shoxchalar ham yana 4 tadan mayda shoxchalarga boʻlingan va ularni har birida bittadan olma bor, barcha olmalar sonini hisoblang.", "20", "12", "64", "16", "64"));
        dataList.add(new TestData("Men bir son o'yladim. Uning yarmiga choragini qo'shsak, 18 hosil bo'ladi. Savol: Men qanday son o'ylabman?", "36", "9", "18", "24", "24"));
        dataList.add(new TestData("Qanday sonni hech qanday matematik amal bajarmasdan cheksizlik belgisiga aylantirish mumkin?", "8", "3", "6", "9", "8"));
        dataList.add(new TestData("100 so'm pulingiz bor. 100 ta hayvon olishingiz kerak. Mol - 10 so'm, qo'y - 3 so'm, xo'roz - 50 tiyin. Qaysi hayvonlardan nechtadan olasiz?", "Mol 5 ta, qo'y bitta, xo'roz 94 ta", "To'g'ri javob yo'q", "Mol 2 ta, qo'y ikkita, xo'roz 116 ta", "Mol 3 ta, qo'y uchta, xo'roz 94 ta", "Mol 5 ta, qo'y bitta, xo'roz 94 ta"));
        dataList.add(new TestData("Stolda 70 dona oq qog'oz turibdi. Har 10 soniyada 10 ta qog'ozni sanash mumkin. Bu holda 50 ta qog'oz sanab olish uchun nechi soniya vaqt ketadi?", "40", "20", "70", "50", "20"));
        dataList.add(new TestData("Quyon o'rmondagi hayvonlarga shunday savol berdi: «Agar men ayiqdan og'irroq bo'lsam-u, lekin chumolidan yengilroq bo'lsam, oramizda kim eng yengil bo'ladi?", "To'g'ri javob yo'q", "Chumoli", "Ayiq", "Quyon", "Ayiq"));
        dataList.add(new TestData("Qanday sharoitda qora mushukka uyga kirish oson bo'ladi?", "Tunda", "Tongda", "To'g'ri javob yo'q", "Eshik ochiq bo'lsa", "Eshik ochiq bo'lsa"));
        dataList.add(new TestData("Bu xarf deyarli dunyoning barcha alfavitlarida 1 xil yozilishi bilan rekord o'rnatgan. bu qaysi xarf?", "O", "A", "X", "Z", "O"));
        dataList.add(new TestData("Professor kech soat sakkizda budelnikni 9 ga qo'yib uyquga yotdi. U necha soat uxlaydi?", "8 soat", "1 soat", "9 soat", "13 soat", "1 soat"));
        dataList.add(new TestData("Stolda qalam, chizg'ich, sirkul va o'chirg'ich turibdi. Qog'ozga aylana shaklini chizish kerak bo'lsa, birinchi bo'lib nimani olish kerak?", "Sirkulni", "Qalamni", "Qog'ozni", "Chizg'ichni", "Qog'ozni"));
        dataList.add(new TestData("Ikki ota va ikki farzand ketishayotgandi. Do'kondan uchta olma xarid qilishdi. Bo'lmadilar, kesmadilar, teng qilib bo'lib olishdi. Qanday qilib?", "Ota, Ota, bola, bola", "Ota, bola, Ota, Bobo", "Bobo, bola, bola", "Bobo, ota, bola", "Bobo, ota, bola"));
        dataList.add(new TestData("Ikki ota va ikki farzand, har biri bittadan olma yeyishdi ular nechta olma yeyishdi?", "2ta", "4ta", "3ta", "1ta", "3ta"));
        dataList.add(new TestData("Mahmudning 10 ta qo'yi bor edi. 9 tadan boshqa hamma qo'ylari o'lib qoldi. Mahmudning nechta qo'yi qoldi?", "9ta", "1ta", "To'g'ri javob yo'q", "10ta", "9ta"));

        dataList.add(new TestData("1 tonna paxta necha kilogramga teng??", "10,000", "1,000", "100", "10", "1,000"));
        dataList.add(new TestData("3 x 7 x 2 = ?", "12", "42", "21", "6", "42"));
        dataList.add(new TestData("Berilgan so‘zlar ichidan mantiqan ortiqchasini toping.", "Parij", "London", "Nyu-York", "Tokio", "Nyu-York"));
        dataList.add(new TestData("Agar bugun shanba bo‘lsa, 29 kundan keyin xaftaning qaysi kuni bo‘ladi?", "Juma", "Shanba", "Yakshanba", "Dushanba", "Dushanba"));
        dataList.add(new TestData("Agar xozir vaqt 09:46 bo‘lsa, 43 daqiqadan keyin soat necha bo‘ladi?", "10:19", "22:19", "10:29", "22:29", "10:29"));
        dataList.add(new TestData("Ishchining maoshi dastlab 20% ga, so‘ngra yana 20% ga oshirilgan bo‘lsa, uning maoshi necha foizga oshgan?", "44", "50", "42", "40", "44"));
        dataList.add(new TestData("Agar A harfi B harfidan 9 marta katta va B esa V dan 4 marta kichik bo‘lsa, u holda harflar orasidagi munosabatni toping.", "A>V", "A<V", "A=B", "Aniqlab bo‘lmaydi", "A>V"));
        dataList.add(new TestData("18=2, 19=1, 68=3, 17=?", "5", "0", "4", "Aniqlab bo‘lmaydi", "0"));

    }

    public void shuffle() {
        Collections.shuffle(dataList);
    }

    public List<TestData> getTestDataByCount(int count) {
        return dataList.subList(0, count);
    }

}
