 <div v-if="!files.length" class="room-file-upload-example-container">
                    <div class="room-file-upload-example">
                        <div class="room-file-image-example-wrapper">이미지</div>
                        <div class="room-file-notice-item">
                            실사진 최소 3장 이상 등록하셔야 하며, 가로사진을 권장합니다.
                        </div>
                        <div class="room-file-notice-item room-file-notice-item-red">
                            로고를 제외한 불필요한 정보(워터마크,상호,전화번호 등)가 있는 매물은 비공개처리됩니다
                        </div>
                        <div class="room-file-notice-item room-file-upload-button">
                            <div class="image-box">
                                <!-- <div class="image-profile">
            <img :src="profileImage" />
            </div>-->
                                <label for="file">일반 사진 등록</label>
                                <input type="file" id="file" ref="files" @change="imageUpload" multiple />
                            </div>
                        </div>
                    </div>
                </div>