<template>
  <!-- 인트로 화면 넣으면 돼 -->
  <div id='bg'>
    <!-- 높이조절 -->
    <div style='height: 60px;'></div>

    <div
      style='
    position:relative;
    display: flex;
    align-items: center;
    text-align: center;
    justify-content: center;
    width: 800px; height: 150px;
    margin-top: 200px;
    '>
      <div style='flex-direction: column;'>
        <p class='hbtitle newake' style='height:150px'>HOBBY'IT</p>
      </div>
      <img id='stars' src='/assets/Fstar.svg' style='position: absolute; top: -100px; z-index: -1' />
    </div>

    <div style='width: 100%; margin-top: 150px'>
      <div style='position: relative; height: 330px'>
        <!-- <div style="width:100%; height: 1000px; position:absolute; top:100px;
                  background: linear-gradient(180deg, #000211 0%, #000211 54.37%, #0E0F28 100%);">
        </div> -->
        <div id='back-oval' style='z-index: -1'></div>
        <div id='front-oval'>
          <div id='intro'>본캐? 부캐?<br />HOBBY'IT : 세상의 모든 취미를 하나로</div>
        </div>
      </div>

      <div
        style='
          display: flex;
          background: linear-gradient(to bottom, #000211 20%, #0e0f28);
          padding-left: 5%;
          padding-top: 70px;
          margin-top: -3px;
        '
      >
        <div id='typopage' style='min-width: 500px'>
          <div id='text1'>Just Hobby'It</div>
          <div id='text2'>그냥, 취미해!</div>
          <div id='text3'>
            <span style='font-weight: 700; color: #ebb4fe'>Q. </span>
            당신은 어떤 사람인가요<br />회사원? 선생님? 운동선수? 개발자?<br /><br />
            <span style='font-weight: 700; color: #ebb4fe'>A. 좋아하는 것들 : 취미</span>로 표현할게요<br />
            #음악 #여행 #스포츠 #코딩 etc...<br /><br />
            마음에 맞는 동료들과 함께<br />당신의 개성 넘치는 부캐라이프,<br />
            <span style='font-weight: 700; color: #ebb4fe'>HOBBY'IT : 호빗</span>
            에서 즐기세요!
          </div>
          <div>
            <a href='#prebox'>
              <img
                id='emoji' src='/assets/emoji.png'
                style='position: absolute; top: 1200px; left: 600px; width: 10%;' />
            </a>
            <div style='width: 100px; color: #ebb4fe; margin-top: -300px; margin-left: 552px;'>
              click me!
            </div>
          </div>
        </div>
        <div id='typo'>
          <div class='left'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='right'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='left'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='right'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='left'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='right'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='left'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='right'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
          <div class='left'>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='jua'>#덕질</span>
            <span class='eskool'>#cooking</span>
            <span>#홈트</span>
            <span class='ephesis'>#party</span>
            <span class='black-han-sans'>#먹방</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='bauhaus-93'>#art</span>
            <span class='wild-world'>#GAME</span>
            <span class='newake'>#class</span>
            <span class='swagger'>#공예</span>
            <span class='thunder'>#MOVIE</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='gothic-a1'>#독서</span>
            <span class='tropikal'>#fashion</span>
            <span>#여행</span>
            <span class='thunder'>#BOARDGAME</span>
            <span class='fredoka-one' style='color: #8947e2'>#HOBBY’IT</span>
            <span class='black-han-sans'>#스터디</span>
            <span class='nighty-demo'>#MUSIC</span>
            <span>#외국어</span>
            <span class='dotgothic'>#coding</span>
          </div>
        </div>

        <div class='marquee' style='--duration: 100s'>
          <div class='marquee group'>

          </div>

        </div>
      </div>

      <!-- <div style="position: absolute; width: 100%; height: 221px; left: 0px; top: 1099px; background: #000211;"></div> -->
      <div id='prebox' style='height: 10px; margin-top: 400px;'></div>
      <div
        id='boxpage'
        style='
      display: flex;
      align-items: center;
      flex-direction: column;
      margin-top: 80px;
      '>
        <div id='box1'>
          <h1 style='margin-top: 50px; font-size: 40px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25)'>
            <span id='txtchange' style='color:#642EFE;'></span>&nbsp하고 싶은데.. 같이 하지 않을래요?
          </h1>
          <div style='display: flex; align-items: center'>
            <img src='/assets/people.gif' style='width: 50%; margin: 0px 50px 0px 50px' />
            <h1 id='b1txt' style='font-size: 25px'>
              혼자보단 둘,<br />둘보단 다같이!<br /><br />관심있는 모임에 들어가거나,<br />동료들을 구해보는건
              어떨까요?<br />다함께 취미생활을 기록하고 공유하세요.<br />혼자보단 분명 더욱 즐거울겁니다! <br />
              <br />호빗만의 장점을 더 알아볼까요?&nbsp
              <a href='#prebox2'>
                <v-icon id='anim1' color='#642EFE' icon='mdi-chat-alert' style='margin-top: -25px;'></v-icon>
              </a>
            </h1>
          </div>
        </div>

        <div id='prebox2' style='height: 10px; margin-top: 400px;'></div>
        <div style='display: flex; margin-top: 80px'>
          <div id='box2'>
            <h1 style='color: white; margin-top: 40px; font-size: 50px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25)'>
              24/7 즐기는 취미생활
            </h1>
            <h1 style='color: white; margin-top: 20px; font-size: 24px'>
              <span style='color: #5204ba; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25)'
              >사진 공유, 방명록, 화상채팅까지!</span
              ><br />언제 어디서든 추억을 쌓아갈 수 있습니다.<br /><br />내가 속한 모임 별로 특별한 추억들로<br />채워가보세요
              :)
            </h1>
            <img src='/assets/nod.gif' style='width: 50%; margin-top: 0px;' />
          </div>

          <div>
            <div id='box3'>
              <v-icon icon='mdi-lock-open-variant' size='38' style='margin-top: 20px; color:#067FB2'></v-icon>
              <h1 style='color: #0e0f28; margin-top: 10px; font-size: 40px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25)'>
                We are Open!
              </h1>
              <h1 style='color: #0e0f28; margin-top: 20px; font-size: 18px'>
                유입 환영!<br />아무나 자유롭게 모임 가입이 바로 가능하군요!<br />취향이 맞는 다양한 사람들을 만날 수
                있겠어요<br />누구나 welcome!
              </h1>
            </div>
            <div id='box4'>
              <v-icon icon='mdi-lock' size='38' style='margin-top: 20px; color: #E06C30;'></v-icon>
              <h1 style='color: #0e0f28; margin-top: 10px; font-size: 40px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25)'>
                Friends & Family!
              </h1>
              <h1 style='color: #0e0f28; margin-top: 20px; font-size: 18px'>
                좀 더 프라이빗한 모임을 원하시나요?<br />가입신청 인사, 활동 중인 모임 등을<br />확인 후에
                초대할수도 있습니다<br />우리들만의 아지트가 필요할때도 있는 법이죠
              </h1>
            </div>
          </div>
        </div>

        <div
          id='big'
          style='
            /* color: #9078b8; */
            color: white;
            width: 1700px;
            text-align: center;
            margin: 500px 200px 200px 200px;
            font-size: 170px;
            display: flex;
            '>
          <h3 id='bigl'>Your Hobby,&nbsp</h3>
          <h3 id='bigr'>Your Style.</h3>
        </div>

        <div id='cards' style='height: 1800px'>
          <div style='position: relative'>
            <div id='card1'>
              <div style='width: 300px; height: 300px; margin-top: 10px'>
                <img src='/assets/home3.gif' style='width: 100%; height: 100%; object-fit: cover' />
                <div
                  style='
                    font-size: 40px;
                    margin-left: 10px;
                    background: linear-gradient(180deg, #642efe 0%, #fa8eb6 100%);
                    -webkit-background-clip: text;
                    -webkit-text-fill-color: transparent;
                  '
                >
                  끝이 없다!
                </div>
                <div style='font-size: 24px; margin: 10px 0px 0px 15px; color: white'>
                  하고싶은거 다 해<br />취미엔 끝이 없으니까!<br />어디서? 호빗에서!
                </div>
              </div>
            </div>
            <div id='card2'>
              <div style='width: 500px; height: 500px; margin-top: 10px'>
                <img src='/assets/home4.gif' style='width: 100%; height: 100%' />
                <div
                  style='
                    font-size: 40px;
                    margin-right: 10px;
                    background: linear-gradient(180deg, #642efe 0%, #fa8eb6 100%);
                    -webkit-background-clip: text;
                    -webkit-text-fill-color: transparent;
                  '
                >
                  나 혼자 즐기긴 아깝지
                </div>
                <div style='font-size: 24px; color: white; margin-top: 50px; margin-right: 15px'>
                  찍고 공유하고, 구경하고 떠들고<br />함께할수록 풍성해지는 내 취미모임<br />만능 온라인 소모임 플랫폼!
                </div>
              </div>
            </div>
            <div id='card3'>
              <div style='width: 600px; height: 600px; margin-top: 10px'>
                <img src='/assets/home2.gif' style='width: 100%; height: 100%' />
                <div
                  style='
                    font-size: 40px;
                    margin-left: 10px;
                    background: linear-gradient(180deg, #642efe 0%, #fa8eb6 100%);
                    -webkit-background-clip: text;
                    -webkit-text-fill-color: transparent;
                  '
                >
                  나를 만드는 것은 나 자신!
                </div>
                <div style='font-size: 24px; margin-left: 16px; color: white'>
                  <br /><br />취미로 개성을 표현하세요<br />다양한 부캐 라이프가 모여서 본캐가 될거에요<br />더 개성있는 "나"를 만들어가세요<br />무엇을 망설이는
                  건가요?&nbsp&nbsp이제 그냥 HOBBY'IT!
                </div>
              </div>
            </div>
            <div id='card4'>
              <div style='width: 400px; height: 400px; margin-top: 10px'>
                <img src='/assets/home1.gif' style='width: 100%; height: 100%;' />
                <div
                  style='
                    font-size: 40px;
                    margin-left: 10px;
                    margin-right: 10px;
                    background: linear-gradient(180deg, #642efe 0%, #fa8eb6 100%);
                    -webkit-background-clip: text;
                    -webkit-text-fill-color: transparent;
                  '
                >
                  중요한건 즐기는 마음
                </div>
                <div style='font-size: 24px; margin-left: 15px; margin-right: 15px; color: white'>
                  <br />가볍게 즐기거나,<br />진심으로 즐기거나,<br />자유롭게 활동하세요!
                </div>
              </div>
            </div>

            <div
              style='
                position: absolute;
                width: 1920px;
                height: 1080px;
                left: -900px;
                top: 200px;
                width: 1920px;
                height: 1080px;
                background: radial-gradient(50% 50% at 50% 50%, #d534ef 0%, rgba(36, 39, 75, 0) 100%);
                filter: blur(100px);
              '
            ></div>
          </div>
        </div>


        <!-- 모달테스트버튼 -->
        <!-- <div id="testy">
          <v-btn style="background-color: red;">test-memberupdate
            <v-dialog v-model="memupdate" activator="parent">
              <member-update @closememupdate="closememupdate" />
            </v-dialog>
          </v-btn>
        </div> -->

        <!-- <div id="testy">
          <v-btn style="background-color: red;">test-updatehobby
            <v-dialog v-model="hobupdate" activator="parent">
              <update-hobby @closehobupdate="closehobupdate" />
            </v-dialog>
          </v-btn>
        </div> -->


        <div id='qwerty' style='position: relative; margin-right: 1000px'>
          <div
            id='foot1'
            style='
              position: absolute;
              left: 79px;
              top: 648px;
              width: 27px;
              height: 86px;
              background: linear-gradient(180deg, #0e0f28 0%, #f7dada 100%);
              z-index: 5;
            '
          ></div>
          <div
            id='foot2'
            style='
              position: absolute;
              left: 74.57px;
              top: 823.1px;
              width: 27px;
              height: 86px;
              background: #f7dada;
              transform: rotate(12.43deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot3'
            style='
              position: absolute;
              left: 60.89px;
              top: 1013.24px;
              width: 27px;
              height: 86px;
              background: #f7dada;
              transform: rotate(-15.66deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot4'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 170.36px;
              top: 1150px;
              background: #f7dada;
              transform: rotate(-60.3deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot5'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 350px;
              top: 1231.79px;
              background: #f7dada;
              transform: rotate(-72.81deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot6'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 545.59px;
              top: 1269px;
              background: #f7dada;
              transform: rotate(84.37deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot7'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 733.99px;
              top: 1287.05px;
              background: #f7dada;
              transform: rotate(104.17deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot8'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 871.21px;
              top: 1343.95px;
              background: #f7dada;
              transform: rotate(-32.82deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot9'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 876.3px;
              top: 1481px;
              background: #f7dada;
              transform: rotate(21.34deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot10'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 763.32px;
              top: 1595.92px;
              background: #f7dada;
              transform: rotate(57.81deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot11'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 611.57px;
              top: 1680px;
              background: #f7dada;
              transform: rotate(53.99deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot12'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 453.87px;
              top: 1783px;
              background: #f7dada;
              transform: rotate(38.78deg);
              z-index: 5;
            '
          ></div>
          <div
            id='foot13'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 364px;
              top: 1948px;
              background: #f7dada;
              z-index: 5;
            '
          ></div>
          <div
            id='foot14'
            style='
              position: absolute;
              width: 27px;
              height: 86px;
              left: 409.74px;
              top: 2090.72px;
              background: linear-gradient(180deg, #f7dada 0%, #0e0f28 100%);
              transform: rotate(-38.49deg);
              z-index: 5;
            '
          ></div>
          <div id='pst1' style='z-index: 6'>
            <img src='/assets/yellowp.svg' />
          </div>
          <div id='pst2' style='z-index: 6'>
            <img src='/assets/bluep.svg' />
          </div>
          <div id='pst3' style='z-index: 6'>
            <img src='/assets/greenp.svg' />
          </div>
          <div style='position: absolute; width: 100%; height: 1540px; left: -287px; top: 648px'>
            <img src='/assets/BLOB.svg' style='z-index: -4' />
          </div>
        </div>
        <div>
          <img src='/assets/HBLOGO.svg' style='width: 300px; margin-top: 2500px;' />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import MemberUpdate from "../components/modals/MemberUpdate.vue";
// import UpdateHobby from "../components/modals/UpdateHobby.vue";

export default {
  components: {
    // MemberUpdate,
    // UpdateHobby,
  },
  data() {
    return {
      c: -1,
      txtlist: ['스터디', '여 행', '운 동', '게 임', '맛집탐방', '덕 질', '코 딩', '파 티'],
      // memupdate: false,
      // hobupdate: false,
    };
  },
  mounted() {
    setInterval(this.tChange, 1000);
    this.scrollAnimation();
    this.animate();
  },

  beforeunmounted() {
    clearInterval(this.tChange);
  },

  methods: {
    marqueeText(count, element, direction) {
      if (count > element.scrollwidth / 2) {
        element.style.transform = `transformX(0)`;
        count = 0;
      }
      element.style.transform = `transformX(${count * direction}px)`;
      return count;
    },
    animate() {
      let count1 = 0;
      let count2 = 0;
      count1++;
      count2++;

      count1 = this.marqueeText(count1, document.querySelector('.left'), -1);
      count2 = this.marqueeText(count2, document.querySelector('.right'), 1);
    },

    // memupdate test
    // openmemupdate() {
    //   this.memupdate = true;
    // },
    // closememupdate() {
    //   this.memupdate = false;
    // },


    // hobupdate test
    // openhobupdate() {
    //   this.hobupdate = true;
    // },
    // closehobupdate() {
    //   this.hobupdate = false;
    // },

    scrollAnimation() {
      gsap.timeline({
        scrollTrigger: {
          trigger: '#typopage',
          start: 'top bottom',
          end: 'bottom bottom',
          scrub: true,
        },
      })
        .from('#text1', { y: 100 * -1, opacity: 0 })
        .from('#text2', { x: 300 * 1, opacity: 0 })
        .from('#text3', { x: 50 * -1, opacity: 0 });

      gsap.timeline({
        scrollTrigger: {
          trigger: '#big',
          start: 'top bottom',
          end: 'bottom bottom',
          scrub: true,
        },
      })
        .from('#bigr', { x: 300 * 1, opacity: 0 })
        .from('#bigl', { x: 300 * -1, opacity: 0 });

      gsap.timeline({
        scrollTrigger: {
          trigger: '#cards',
          start: 'top bottom',
          end: 'bottom bottom',
          scrub: true,
        },
      })
        .from('#card1', { x: 300 * -1, y: 300 * -1, opacity: 0 })
        .from('#card2', { x: 300 * 1, y: 300 * -1, opacity: 0 })
        .from('#card3', { x: 300 * -1, y: 300 * 1, opacity: 0 })
        .from('#card4', { x: 300 * 1, y: 300 * 1, opacity: 0 });

      gsap.timeline({
        scrollTrigger: {
          trigger: '#qwerty',
          start: 'top bottom',
          end: 'bottom bottom',
          scrub: true,
        },
      })
        .from('#foot1', { y: 50 * -1, opacity: 0 })
        .from('#foot2', { y: 50 * -1, opacity: 0 })
        .from('#foot3', { y: 50 * -1, opacity: 0 })
        .from('#foot4', { y: 50 * -1, opacity: 0 });
    },

    tChange() {
      this.c = ++this.c % this.txtlist.length;
      let txt = document.getElementById('txtchange');
      if (txt !== null) {
        txt.innerHTML = this.txtlist[this.c];
      }
    },
  },
};
</script>

<style scoped>

#bg {
  display: flex;
  align-items: center;
  flex-direction: column;
  height: 10000px;
}

a {
  text-decoration: none;
  color: #000211
}

p {
  display: flex;
  align-items: center;
  text-align: center;
  font-style: normal;
  font-weight: 400;
  font-size: 124px;
  line-height: 100px;
  background: linear-gradient(180deg, #ad00ff 24.05%, #fa8eb6 72.16%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

/* 별 움직이는 동작 */
#stars {
  animation: rotate-image 100s linear infinite;
  transform-origin: 50% 50%;
}

@keyframes rotate-image {
  100% {
    transform: rotate(-360deg);
  }
}

#back-oval {
  position: absolute;
  top: -110px;
  width: 120%;
  height: 380px;
  background: radial-gradient(50% 50% at 50% 50%, #d534ef 0%, rgba(36, 39, 75, 0) 100%);
  filter: blur(100px);
  left: -10%;
}

#front-oval {
  position: absolute;
  box-sizing: border-box;
  width: 120%;
  left: -10%;
  border-radius: 50% 50% 0 0 / 50% 50% 0 0;
  /* background: linear-gradient(360deg, #000211, #0E0F28); */
  /* background: #000211; */
  border-top: 5px solid transparent;
  background-image: linear-gradient(#000211, #000211),
  radial-gradient(50.13% 50.13% at 50% 0%, #ebb4fe 0%, rgba(217, 217, 217, 0) 100%);
  background-origin: border-box;
  background-clip: content-box, border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

#intro {
  margin-top: 35px;
  font-style: normal;
  font-weight: 700;
  font-size: 30px;
  display: flex;
  align-items: center;
  text-align: center;

  background: linear-gradient(180deg, #e7b2fa -16.3%, #ad00ff 127.17%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  padding-bottom: 200px;
}

#emoji {
  -webkit-animation: emoji 1s ease-in-out infinite both;
  animation: emoji 1s ease-in-out infinite both;
}

@-webkit-keyframes emoji {
  from {
    -webkit-transform: scale(1);
    transform: scale(1);
    -webkit-transform-origin: center center;
    transform-origin: center center;
    -webkit-animation-timing-function: ease-out;
    animation-timing-function: ease-out;
  }
  10% {
    -webkit-transform: scale(0.91);
    transform: scale(0.91);
    -webkit-animation-timing-function: ease-in;
    animation-timing-function: ease-in;
  }
  17% {
    -webkit-transform: scale(0.98);
    transform: scale(0.98);
    -webkit-animation-timing-function: ease-out;
    animation-timing-function: ease-out;
  }
  33% {
    -webkit-transform: scale(0.87);
    transform: scale(0.87);
    -webkit-animation-timing-function: ease-in;
    animation-timing-function: ease-in;
  }
  45% {
    -webkit-transform: scale(1);
    transform: scale(1);
    -webkit-animation-timing-function: ease-out;
    animation-timing-function: ease-out;
  }
}

@keyframes emoji {
  from {
    -webkit-transform: scale(1);
    transform: scale(1);
    -webkit-transform-origin: center center;
    transform-origin: center center;
    -webkit-animation-timing-function: ease-out;
    animation-timing-function: ease-out;
  }
  10% {
    -webkit-transform: scale(0.91);
    transform: scale(0.91);
    -webkit-animation-timing-function: ease-in;
    animation-timing-function: ease-in;
  }
  17% {
    -webkit-transform: scale(0.98);
    transform: scale(0.98);
    -webkit-animation-timing-function: ease-out;
    animation-timing-function: ease-out;
  }
  33% {
    -webkit-transform: scale(0.87);
    transform: scale(0.87);
    -webkit-animation-timing-function: ease-in;
    animation-timing-function: ease-in;
  }
  45% {
    -webkit-transform: scale(1);
    transform: scale(1);
    -webkit-animation-timing-function: ease-out;
    animation-timing-function: ease-out;
  }
}

#typo {
  height: 800px;
  overflow: hidden;
  margin-left: -2200px;
}

.left {
  flex-shrink: 0;
  display: flex;
  justify-content: space-around;
  min-width: 100%;
  animation: scroll 30s linear infinite;
  animation-direction: reverse;
}

@keyframes scroll {
  from {
    transform: translateX(0);
  }
  to {
    transform: translateX(100);
  }
}

.right {
  flex-shrink: 0;
  display: flex;
  justify-content: space-around;
  min-width: 100%;
  animation: scroll 30s linear infinite;
}

@keyframes scroll {
  from {
    transform: translateX(0);
  }
  to {
    transform: translateX(100%);
  }
}

#typo .right {
  rotate: -60deg;
  color: white;
  font-size: 60px;
  display: inline-block;
  white-space: nowrap;
  margin-top: 70px;
}

#typo .left {
  rotate: -60deg;
  color: white;
  font-size: 60px;
  display: inline-block;
  white-space: nowrap;
  margin-top: 70px;
}

#text1 {
  background-clip: text;
  align-items: center;
  background: linear-gradient(180deg, #642efe 13.55%, #ffffff 63.55%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  margin-top: 50px;
  font-size: 40px;
}

#text2 {
  color: white;
  font-weight: 700;
  font-size: 96px;
  line-height: 127px;
  display: flex;
  align-items: center;
}

#text3 {
  /*color:#FA8EB6;*/
  font-size: 24px;
  line-height: 48px;
  color: #e9d7dd;
  margin-top: 60px;
}

#box1 {
  width: 80%;
  height: 600px;
  background: linear-gradient(180deg, #f4d1d6 0%, #f4d1d6 23.41%, #f5d2d7 68.11%, #fadfdd 86.61%, #f4d1d6 100%);
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
  padding-bottom: 10px;
}

#box2 {
  width: 700px;
  height: 600px;
  background: linear-gradient(
    180deg,
    #fa8eb6 0%,
    #f98cb4 55.18%,
    #fca2c3 71.63%,
    #fcb0cb 81.7%,
    #fabad0 96.94%,
    #fbb7cd 100%
  );
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
  padding: 15px;
  margin-left: -100px;
}

#box3 {
  width: 100%;
  height: 280px;
  background: #69fce1;
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
  margin: 0px 15px 40px 45px;
}

#box4 {
  width: 100%;
  height: 280px;
  background: #deffbe;
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: right;
  margin: 0px 15px 20px 45px;
}

#pst1 {
  position: absolute;
  width: 200px;
  height: 200px;
  left: 713.82px;
  top: 1000.74px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(-22deg);
}

#pst2 {
  position: absolute;
  width: 200px;
  height: 200px;
  left: 320.89px;
  top: 1280.89px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(-5deg);
}

#pst3 {
  position: absolute;
  width: 200px;
  height: 200px;
  left: 550.73px;
  top: 1790px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(10deg);
}

#card1 {
  position: absolute;
  width: 320px;
  height: 524px;
  left: -400px;
  top: 30px;
  z-index: 2;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

#card2 {
  position: absolute;
  width: 520px;
  height: 813px;
  left: 0;
  top: 0;
  z-index: 3;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: right;
}

#card3 {
  position: absolute;
  width: 620px;
  height: 986px;
  left: -500px;
  top: 700px;
  z-index: 4;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

#card4 {
  position: absolute;
  width: 420px;
  height: 697px;
  left: 150px;
  top: 900px;
  z-index: 5;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: right;
}

#bigl {
  color: transparent;
  -webkit-text-stroke: 1px #fff;
}

#bigr {
  color: transparent;
  -webkit-text-stroke: 1px #fff;
  margin-left: -200px;
}

#big {
  -webkit-animation: text-flicker-in-glow 1s linear both;
  animation: text-flicker-in-glow 1s linear both;
}

@-webkit-keyframes text-flicker-in-glow {
  0% {
    opacity: 0;
  }
  10% {
    opacity: 0;
    text-shadow: none;
  }
  10.1% {
    opacity: 1;
    text-shadow: none;
  }
  10.2% {
    opacity: 0;
    text-shadow: none;
  }
  20% {
    opacity: 0;
    text-shadow: none;
  }
  20.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.25);
  }
  20.6% {
    opacity: 0;
    text-shadow: none;
  }
  30% {
    opacity: 0;
    text-shadow: none;
  }
  30.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  30.5% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  30.6% {
    opacity: 0;
    text-shadow: none;
  }
  45% {
    opacity: 0;
    text-shadow: none;
  }
  45.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  50% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  55% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  55.1% {
    opacity: 0;
    text-shadow: none;
  }
  57% {
    opacity: 0;
    text-shadow: none;
  }
  57.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35);
  }
  60% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35);
  }
  60.1% {
    opacity: 0;
    text-shadow: none;
  }
  65% {
    opacity: 0;
    text-shadow: none;
  }
  65.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  75% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  75.1% {
    opacity: 0;
    text-shadow: none;
  }
  77% {
    opacity: 0;
    text-shadow: none;
  }
  77.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.4), 0 0 110px rgba(255, 255, 255, 0.2), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  85% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.4), 0 0 110px rgba(255, 255, 255, 0.2), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  85.1% {
    opacity: 0;
    text-shadow: none;
  }
  86% {
    opacity: 0;
    text-shadow: none;
  }
  86.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.6), 0 0 60px rgba(255, 255, 255, 0.45), 0 0 110px rgba(255, 255, 255, 0.25), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  100% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.6), 0 0 60px rgba(255, 255, 255, 0.45), 0 0 110px rgba(255, 255, 255, 0.25), 0 0 100px rgba(255, 255, 255, 0.1);
  }
}

@keyframes text-flicker-in-glow {
  0% {
    opacity: 0;
  }
  10% {
    opacity: 0;
    text-shadow: none;
  }
  10.1% {
    opacity: 1;
    text-shadow: none;
  }
  10.2% {
    opacity: 0;
    text-shadow: none;
  }
  20% {
    opacity: 0;
    text-shadow: none;
  }
  20.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.25);
  }
  20.6% {
    opacity: 0;
    text-shadow: none;
  }
  30% {
    opacity: 0;
    text-shadow: none;
  }
  30.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  30.5% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  30.6% {
    opacity: 0;
    text-shadow: none;
  }
  45% {
    opacity: 0;
    text-shadow: none;
  }
  45.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  50% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  55% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.45), 0 0 60px rgba(255, 255, 255, 0.25);
  }
  55.1% {
    opacity: 0;
    text-shadow: none;
  }
  57% {
    opacity: 0;
    text-shadow: none;
  }
  57.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35);
  }
  60% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35);
  }
  60.1% {
    opacity: 0;
    text-shadow: none;
  }
  65% {
    opacity: 0;
    text-shadow: none;
  }
  65.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  75% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.35), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  75.1% {
    opacity: 0;
    text-shadow: none;
  }
  77% {
    opacity: 0;
    text-shadow: none;
  }
  77.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.4), 0 0 110px rgba(255, 255, 255, 0.2), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  85% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.55), 0 0 60px rgba(255, 255, 255, 0.4), 0 0 110px rgba(255, 255, 255, 0.2), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  85.1% {
    opacity: 0;
    text-shadow: none;
  }
  86% {
    opacity: 0;
    text-shadow: none;
  }
  86.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.6), 0 0 60px rgba(255, 255, 255, 0.45), 0 0 110px rgba(255, 255, 255, 0.25), 0 0 100px rgba(255, 255, 255, 0.1);
  }
  100% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(255, 255, 255, 0.6), 0 0 60px rgba(255, 255, 255, 0.45), 0 0 110px rgba(255, 255, 255, 0.25), 0 0 100px rgba(255, 255, 255, 0.1);
  }
}

#anim1 {
  -webkit-animation: jello-vertical 2s infinite both;
  animation: jello-vertical 2s infinite both;
}

@-webkit-keyframes jello-vertical {
  0% {
    -webkit-transform: scale3d(1, 1, 1);
    transform: scale3d(1, 1, 1);
  }
  30% {
    -webkit-transform: scale3d(0.75, 1.25, 1);
    transform: scale3d(0.75, 1.25, 1);
  }
  40% {
    -webkit-transform: scale3d(1.25, 0.75, 1);
    transform: scale3d(1.25, 0.75, 1);
  }
  50% {
    -webkit-transform: scale3d(0.85, 1.15, 1);
    transform: scale3d(0.85, 1.15, 1);
  }
  65% {
    -webkit-transform: scale3d(1.05, 0.95, 1);
    transform: scale3d(1.05, 0.95, 1);
  }
  75% {
    -webkit-transform: scale3d(0.95, 1.05, 1);
    transform: scale3d(0.95, 1.05, 1);
  }
  100% {
    -webkit-transform: scale3d(1, 1, 1);
    transform: scale3d(1, 1, 1);
  }
}

@keyframes jello-vertical {
  0% {
    -webkit-transform: scale3d(1, 1, 1);
    transform: scale3d(1, 1, 1);
  }
  30% {
    -webkit-transform: scale3d(0.75, 1.25, 1);
    transform: scale3d(0.75, 1.25, 1);
  }
  40% {
    -webkit-transform: scale3d(1.25, 0.75, 1);
    transform: scale3d(1.25, 0.75, 1);
  }
  50% {
    -webkit-transform: scale3d(0.85, 1.15, 1);
    transform: scale3d(0.85, 1.15, 1);
  }
  65% {
    -webkit-transform: scale3d(1.05, 0.95, 1);
    transform: scale3d(1.05, 0.95, 1);
  }
  75% {
    -webkit-transform: scale3d(0.95, 1.05, 1);
    transform: scale3d(0.95, 1.05, 1);
  }
  100% {
    -webkit-transform: scale3d(1, 1, 1);
    transform: scale3d(1, 1, 1);
  }
}

.hbtitle {
  -webkit-animation: focus-in-expand 0.8s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
  animation: focus-in-expand 0.8s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

@-webkit-keyframes focus-in-expand {
  0% {
    letter-spacing: -0.5em;
    -webkit-filter: blur(12px);
    filter: blur(12px);
    opacity: 0;
  }
  100% {
    -webkit-filter: blur(0px);
    filter: blur(0px);
    opacity: 1;
  }
}

@keyframes focus-in-expand {
  0% {
    letter-spacing: -0.5em;
    -webkit-filter: blur(12px);
    filter: blur(12px);
    opacity: 0;
  }
  100% {
    -webkit-filter: blur(0px);
    filter: blur(0px);
    opacity: 1;
  }
}

@font-face {
  font-family: 'baushaus93';
  src: url('/assets/fonts/Bauhaus93.woff2');
}

@font-face {
  font-family: 'newake';
  src: url('/assets/fonts/NewakeDemo.woff2');
}

@font-face {
  font-family: 'nighty-demo';
  src: url('/assets/fonts/NightyDEMO.woff2');
}

@font-face {
  font-family: 'fredoka-one';
  src: url('/assets/fonts/FredokaOne-Regular.woff2');
}

@font-face {
  font-family: 'eskool';
  src: url('/assets/fonts/Eskool-Regular.woff2');
}

@font-face {
  font-family: 'ephesis';
  src: url('/assets/fonts/Ephesis-Regular.woff2');
}

@font-face {
  font-family: 'wild-world';
  src: url('/assets/fonts/WildWorldBOLD.woff2');
}

@font-face {
  font-family: 'thunder';
  src: url('/assets/fonts/Thunder-ExtraBoldLC.woff2');
}

@font-face {
  font-family: 'jua';
  src: url('/assets/fonts/Jua-Regular.woff2');
}

@font-face {
  font-family: 'dotgothic';
  src: url('/assets/fonts/DotGothic16-Regular.woff2');
}

@font-face {
  font-family: 'tropikal';
  src: url('/assets/fonts/Tropikal-Bold.woff2');
}

@font-face {
  font-family: 'swagger';
  src: url('/assets/fonts/SwaggerTTF.woff2');
}

@font-face {
  font-family: 'gothic-a1';
  src: url('/assets/fonts/GothicA1-Bold.woff2');
}

@font-face {
  font-family: 'black-han-sans';
  src: url('/assets/fonts/BlackHanSans-Regular.woff2');
}

.newake {
  font-family: newake;
}

.nighty-demo {
  font-family: nighty-demo;
}

.fredoka-one {
  font-family: fredoka-one;
}

.eskool {
  font-family: eskool;
}

.ephesis {
  font-family: ephesis;
}

.bauhaus-93 {
  font-family: baushaus93;
}

.wild-world {
  font-family: wild-world;
}

.thunder {
  font-family: thunder;
}

.jua {
  font-family: jua;
}

.dotgothic {
  font-family: dotgothic;
}

.tropikal {
  font-family: tropikal;
}

.swagger {
  font-family: swagger;
}

.gothic-a1 {
  font-family: gothic-a1;
}

.black-han-sans {
  font-family: black-han-sans;
}
</style>
