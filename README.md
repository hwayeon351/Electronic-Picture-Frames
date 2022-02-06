# Electronic-Picture-Frames
### 전자액자 앱

#### 사진 앱에서 사진을 선택해 앱에 사진을 추가하고, 전자액자를 실행해 가로화면으로 사진이 하나씩 넘어가는 기능을 구현한 앱 입니다.
### Blog
* <https://hwayomingdlog.tistory.com/214>
* <https://hwayomingdlog.tistory.com/217>
</br>

## 주 기능
### 사진 추가하기
* 사진 추가하기 버튼을 클릭해서 사진을 선택할 수 있습니다.
* 선택한 사진 목록을 확인할 수 있습니다.
</br>

### 전자액자 실행하기
* 사진 추가하기 기능을 통해 선택한 사진들을 5초에 1장씩 감상할 수 있습니다.
* 가로화면을 지원하여 큰 화면으로 사진들을 볼 수 있습니다.
</br>

## 활용 기술
* LinearLayout - 선택한 사진들을 각각 LinearLayout의 하위 ImageView에 담아 선택한 사진 목록을 확인할 수 있게 하였습니다.
* SAF(Storage Access Framework) - Content Provider 사용 방법 중 하나인 SAF 방법을 활용하여 기기 내의 사진 앱에 접근하여 사진 컨텐츠를 불러왔습니다.
* timer - timer 객체를 사용해서 5초마다 사진이 전환되도록 구현하였습니다. 두 개의 ImageView의 alpha 값을 조정하고 animate() 호출을 통해 이미지가 전환되는 Fade-In 애니메이션을 적용했습니다.
</br>

***
<img src="/img/img0.png" width="300px" height="600px" title="" alt=""></img>
<img src="/img/img1.png" width="300px" height="600px" title="" alt=""></img>
