import { createInstance } from '@/api/index';

const PATH = 'member/';

const instance = createInstance(PATH);

// 1.회원가입
function memberSignup(data) {
  return instance.post('signup', data);
}

// 2.이메일인증

// 3.로그인
function memberLogin(data) {
  return instance.post('login', data);
}

// 4.비밀번호 리셋
function resetPassword(data) {
  return instance.post('password/reset', data);
}

// 5.로그아웃
function memberLogout(nickname) {
  return instance.get('logout');
}

// 6.마이페이지(타인)
function getOthersMyPage(nickname) {
  return instance.get(`${nickname}`);
}

// 7.마이페이지 정보수정
function updateMyPage(data) {
  return instance.put('', data);
}

// 8.마이페이지 (본인)
function getMyPage() {
  return instance.get('');
}

// 9.회원탈퇴
function memberDelete() {
  return instance.post('delete');
}

// 10.참여중인 모임 리스트 조회
function getParticipatingGroup(nickname) {
  return instance.get(`hobby/${nickname}`);
}

// 11.대기중인 모임 리스트 조회
function getWaitingGroup() {
  return instance.get('hobby');
}

export {
  memberSignup,
  memberLogin,
  memberMyPage,
  memberLogout,
  memberUpdateMyPage,
  memberOthersMyPage,
  memberFindPassword,
};
