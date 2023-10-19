package studio.tsukistar.demo.Service.CreateCode;

import org.springframework.stereotype.Service;

import studio.tsukistar.demo.Dao.ProjectInformationDao;
import studio.tsukistar.demo.Entity.ProjectInformationEntity;
import studio.tsukistar.demo.Service.StoreProjectInformation.StoreProjectInformationService;

@Service
public class CreateCodeServiceImpl implements CreateCodeService {
    private final ProjectInformationDao projectInformationDao;
    private final StoreProjectInformationService storeProjectInformationService;
    private static final String BASE34_CHARACTERS = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZ";
    private static final String BASE31_CHARACTERS = "0123456789ADEFGHIJKLMNPQRSTUVWXY";

    public CreateCodeServiceImpl(ProjectInformationDao projectInformationDao, StoreProjectInformationService storeProjectInformationService) {
            this.projectInformationDao = projectInformationDao;
            this.storeProjectInformationService = storeProjectInformationService;
    }
    @Override
    public String createCode(String name, String category) {
        String code;
        String operation = "新建编码";
        code = projectInformationDao.selectLatestProjectCode(category);
        if(category.equals("QT")) {
            code = this.otherCodeCreate(code);
        } else if(category.isEmpty()){
            return code;
        } else {
            code = this.mainCodeCreate(code);
        }
        ProjectInformationEntity projectInformation = storeProjectInformationService.storeProjectInformation(operation, code, name, category);
        projectInformationDao.addOperationInformation(projectInformation);
        return code;
    }

    private String mainCodeCreate(String code) {
        String second_char = String.valueOf(code.charAt(1));
        String last_code = code.substring(2);
        if(last_code.equals("ZZZ")) {
            last_code = "000";
            second_char = decimalToBase((baseToDecimal(31, second_char)+1), 31);
        } else {
            last_code = decimalToBase((baseToDecimal(34, last_code)+1), 34);
            int addZero_number = 3 - last_code.length();
            StringBuilder last_codeBuilder = new StringBuilder(last_code);
            while(addZero_number>0) {
                last_codeBuilder.insert(0, "0");
                addZero_number--;
            }
            last_code = last_codeBuilder.toString();
        }
        return ("Pro" + second_char + last_code);
    }

    private String otherCodeCreate(String code) {
        String code_last = code.substring(1);
        int code_number = baseToDecimal(34, code_last);
        code_number++;
        code_last = decimalToBase(code_number, 34);
        int addZero_number = 4 - code_last.length();
        StringBuilder code_lastBuilder = new StringBuilder(code_last);
        while(addZero_number>0) {
            code_lastBuilder.insert(0, "0");
            addZero_number--;
        }
        code_last = code_lastBuilder.toString();
        return ("QtPro" + code_last);
    }

    private String decimalToBase(int decimal, int base) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % base;
            if(base == 34) result.insert(0, BASE34_CHARACTERS.charAt(remainder));
            else result.insert(0, BASE31_CHARACTERS.charAt(remainder));
            decimal /= base;
        }

        return result.toString();
    }

    private int baseToDecimal(int base, String base34) {
        int result = 0;
        int power = 1;
        System.out.println("输入："+base34);
        if (base == 34)
            for (int i = base34.length() - 1; i >= 0; i--) {
                char character = base34.charAt(i);
                int value = BASE34_CHARACTERS.indexOf(character);
                result += value * power;
                power *= base;
            }
        else {
            for (int i = base34.length() - 1; i >= 0; i--) {
                char character = base34.charAt(i);
                int value = BASE31_CHARACTERS.indexOf(character);
                result += value * power;
                power *= base;
            }
        }
        return result;
    }
}