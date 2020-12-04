package com.karczmarzyk.advent2020.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldValidatorTest {
    FieldValidator validator;

    @BeforeEach
    void setUp() {
        validator = new FieldValidator();
    }

    @Test
    void idValidate() {
        String[] tab = {"pid:","000000001"};
        String[] tab2 = {"pid:","0123456789"};

       assertTrue( validator.idValidate( tab ));
       assertFalse( validator.idValidate( tab2 ) );
    }

    @Test
    void eyesValidate() {
        String[] tab = {"ecl:","brn"};
        String[] tab2 = {"ecl:","wat"};

        assertTrue( validator.eyesValidate( tab ));
        assertFalse( validator.eyesValidate( tab2 ) );
    }

    @Test
    void hairColorValidate() {
        String[] tab = {"hcl:","#123abc"};
        String[] tab2 = {"hcl:","#123abz"};

        assertTrue( validator.hairColorValidate( tab ));
        assertFalse( validator.hairColorValidate( tab2 ) );
    }

    @Test
    void heightValidate() {
        String[] tab = {"hgt:","60in"};
        String[] tab2 = {"hgt:","190cm"};
        String[] tab3 = {"hgt:","190in"};
        String[] tab4 = {"hgt:","190"};

       assertAll( ()->assertTrue( validator.heightValidate( tab )),
                  ()->assertTrue( validator.heightValidate( tab2 ) ),
                  ()->assertFalse( validator.heightValidate( tab3 ) ),
                  ()->assertFalse( validator.heightValidate( tab4 ) ));
    }

    @Test
    void birthdayValidate() {
        String[] tab = {"byr:","2002"};
        String[] tab2 = {"byr:","2003"};

        assertAll( ()->assertTrue( validator.birthdayValidate( tab )),
                   ()->assertFalse( validator.birthdayValidate( tab2 ) ));
    }

    @Test
    void issueYearValidate() {
    }

    @Test
    void expirationYearValidate() {
    }
}