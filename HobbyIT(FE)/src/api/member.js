import { createInstance } from '@/api/index';

const PATH = 'member/';

const instance = createInstance(PATH);

// 1
function memberSignup(data) {
  return instance.post('signup', data);
}

// 2

// 3
function memberLogin(data) {
  return instance.post('login', data);
}

export { memberSignup };
