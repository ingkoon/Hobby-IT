import { createInstance, createInstanceWithNoAuth, fileConfig } from '@/api/index';

const PATH = '/article';

const instance = createInstance(PATH);
const multipartInstance = createInstance(PATH, fileConfig);
const instanceWithNoAuth = createInstanceWithNoAuth(PATH);
const multipartInstanceWithNoAuth = createInstanceWithNoAuth(PATH, fileConfig);

// 1.회원가입
function memberSignup(data) {
  return multipartInstanceWithNoAuth.post('/signup', data);
}

// 42. 모임 방명록 등록
function hobbyPostitAdd(data) {
  return multipartInstanceWithNoAuth.post('/');
}

//43

//44

//45

//46

//47

//48

//49

//50
