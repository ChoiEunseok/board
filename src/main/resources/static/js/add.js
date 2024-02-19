 //1)유효성 체크
bname.addEventListener('focus', evt=> {
  evt.target.style.backgroundColor = 'Lightgray';
});

bname.addEventListener('blur', evt=> {
  evt.target.style.backgroundColor = 'initial';
  //유효성체크
  console.log(evt.target.value);
  const pattern = /[ㄱ-ㅎ가-힣_\-]{3,10}/;
    if(pattern.test(evt.target.value)) {
      console.log('패턴 일치');
      errBname.classList.remove('on');
      errBname.textContent = '';
    } else {
      console.log('패턴 불일치');
      errBname.classList.add('on');
      errBname.textContent = '한글, 3~10자리';
      errBname.target.focus();
      errBname.target.select();
    }
});
