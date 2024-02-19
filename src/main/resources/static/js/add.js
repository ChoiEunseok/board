//유효성 체크
/*
bname.addEventListener('focus', evt=> {
  evt.target.style.backgroundColor = 'Lightgray';
});

bname.addEventListener('blur', evt=> {
  evt.target.style.backgroundColor = 'initial';
  //유효성체크
  console.log(evt.target.value);
  const pattern = /[ㄱ-ㅎ가-힣_\-]{3,10}/;
    if(pattern.test(evt.target.value)) {
      errBname.classList.remove('on');
      errBname.textContent = '';
    } else {
      errBname.classList.add('on');
      errBname.textContent = '한글, 3~10자리';
      errBname.target.focus();
      errBname.target.select();
    }
});

title.addEventListener('focus', evt=> {
  evt.target.style.backgroundColor = 'Lightgray';
});

title.addEventListener('blur', evt=> {
  evt.target.style.backgroundColor = 'initial';
  //유효성체크
  console.log(evt.target.value);
  const pattern = /[a-zA-Z0-9ㄱ-ㅎ가-힣~!@#$%^&*()-_=+]{3,30}/;
    if(pattern.test(evt.target.value)) {
      errTitle.classList.remove('on');
      errTitle.textContent = '';
    } else {
      errTitle.classList.add('on');
      errTitle.textContent = '한글,특수문자,숫자,영어 3~30자리';
      errTitle.target.focus();
      errTitle.target.select();
    }
});

userContent.addEventListener('focus', evt=> {
  evt.target.style.backgroundColor = 'Lightgray';
});

userContent.addEventListener('blur', evt=> {
  evt.target.style.backgroundColor = 'initial';
  //유효성체크
  console.log(evt.target.value);
  const pattern = /[a-zA-Z0-9ㄱ-ㅎ가-힣~!@#$%^&*()-_=+]{3,500}/;
    if(pattern.test(evt.target.value)) {
      errContent.classList.remove('on');
      errContent.textContent = '';
    } else {
      errContent.classList.add('on');
      errContent.textContent = '한글,특수문자,숫자,영어 3~500자';
      errContent.target.focus();
      errContent.target.select();
    }
});

*/
