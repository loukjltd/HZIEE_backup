function isEmpty(str) {
    return str != null && str.length > 0;
}


function equals(str1, str2) {
    return str1 === str2;
}


function isChinese(str) {
    var str = str.replace(/(^\s*)|(\s*$)/g,'');
    return /^[\u4E00-\uFA29]*$/.test(str)
        && (!/^[\uE7C7-\uE7F3]*$/.test(str));
}


function isEmail(str) {
    return /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(str);
}

function isPost(str) {
    return /^\d{1,6}$/.test(str);
}

function isMobile(str) {
    return /^1[35]\d{9}/.test(str);
}

function isQQ(str) {
    return /^\d{5,10}$/.test(str);
}

function isDate(str) {
    const reg = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
    return reg.test(str);
}


function isIdCardNo(idNumber) {
    const factorArr = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];
    const varArray = [];
    let lngProduct = 0;
    let intCheckDigit;

    if ((idNumber.length !== 15) && (idNumber.length !== 18)) {
        return false;
    }
    for(let i = 0; i < idNumber.length; i ++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i !== 17)) {
            return false;
        }
        else if (i < 17) {
            varArray[i] = varArray[i]*factorArr[i];
        }
    }
    if (idNumber.length === 18) {
        const date8 = idNumber.substring(6, 14);
        if (isDate(date8) === false) {
            return false;
        }
        for(let i = 0; i < 17; i ++) {
            lngProduct = lngProduct + varArray[i];
        }
        intCheckDigit = 12 - lngProduct % 11;
        switch (intCheckDigit) {
            case 10:
                intCheckDigit = 'X';
                break;
            case 11:
                intCheckDigit = 0;
                break;
            case 12:
                intCheckDigit = 1;
                break;
        }
        if (varArray[17].toUpperCase() !== intCheckDigit) {
            return false;
        }
    }
    else {
        const date6 = idNumber.substring(6, 12);
        if (isDate(date6) === false)
        {
            return false;
        }
    }
    return true;
}

function checkPassword() {
    let psw1 = document.getElementById("password").value;
    let psw2 = document.getElementById("passwordAgain").value;
    if (!isEmpty(psw1) || !isEmpty(psw2)) {
        alert("请输入密码！");
    } else {
        if (equals(psw1, psw2) === true) {
            alert("您输入的两个密码相同！");
        } else {
            alert("您输入的两个密码不同！");
        }
    }
}

function checkRealName() {
    let lastName = document.getElementById("lastName").value;
    let firstName = document.getElementById("firstName").value;
    if (!isEmpty(lastName) || !isEmpty(firstName)) {
        alert("请输入姓名！");
    } else {
        if (isChinese(lastName) && isChinese(firstName)) {
            alert("您输入的姓名正确！");
        } else {
            alert("您输入的姓名有误！");
        }
    }

}

function checkEmail() {
    let testEmail = document.getElementById("email").value;
    if (!isEmpty(testEmail)) {
        alert("请输入邮箱！")
    } else {
        if (isEmail(testEmail)) {
            alert("您输入的邮箱正确！");
        } else {
            alert("您输入的邮箱有误！");
        }
    }
}

function checkPhoneNumber() {
    let testPhoneNumber = document.getElementById("phoneNumber").value;
    if (!isEmpty(testPhoneNumber)) {
        alert("请输入手机号！")
    } else {
        if (isMobile(testPhoneNumber)) {
            alert("您输入的手机号正确！");
        } else {
            alert("您输入的手机号有误！")
        }
    }

}

function checkQqNumber() {
    let qqNumber = document.getElementById("qqNumber").value;
    if (!isEmpty(qqNumber)) {
        alert("请输入QQ号");
    } else {
        if (isQQ(qqNumber)) {
            alert("您输入的QQ号正确！");
        } else {
            alert("您输入的QQ号有误！");
        }
    }
}

function checkAreaCode() {
    let areaCode = document.getElementById("areaCode").value;
    if (!isEmpty(areaCode)) {
        alert("请输入邮编！");
    } else {
        if (isPost(areaCode)) {
            alert("您输入的邮编正确！");
        } else {
            alert("您输入的邮编有误！");
        }
    }

}

function checkBirthDay() {
    let birthDay = document.getElementById("birthDay").value;
    if (!isEmpty(birthDay)) {
        alert("请输入生日！");
    } else {
        if (isDate(birthDay)) {
            alert("您输入的生日正确！");
        } else {
            alert("您输入的生日有误！");
        }
    }

}

function checkIdNumber() {
    let testIdNumber = document.getElementById("idNumber").value;
    if (!isEmpty(testIdNumber)) {
        alert("请输入身份证号！")
    } else {
        if (isIdCardNo(testIdNumber)) {
            alert("您输入的身份证号正确！")
        } else {
            alert("您输入的身份证号有误！")
        }
    }
}