var fileControl = function(){
    var f = {};
    var totalFileSize = 0; // 등록할 전체 파일 사이즈
    var fileList = new Array(); // 파일 리스트
    var fileSizeList = new Array();
    var selector_level,
        selector_input,
        selector_preview,
        limit_type,
        limit_count,
        parents,
        upload_size,
        max_upload_size;

    f.fn={
        colorChange:function(e, el, color){
            e.stopPropagation();
            e.preventDefault();
            $(el).css('background',color);
        },
        dropFile:function(e, el){
            e.preventDefault();
            /**
             * Example)
             * data-upload_trigger="true"
             * data-selector_preview="[class=previewImage]"
             * data-selector_input="[class='upload_name']"
             * data-limit_type="IMAGE"
             * data-limit_count="5"
             * data-selector_parents="[class='t-copy']"
             *             *
             *             *
             *           *
             */
            // 태그 정보
            selector_level = $(el).attr("data-selector_level");
            selector_input = $(el).attr("data-selector_input");
            parents = $(el).closest($(el).attr("data-selector_parents"));
            selector_preview = $(el).attr("data-selector_preview");
            limit_type     = $(el).attr("data-limit_type");
            limit_count    = Number.parseInt($(el).attr("data-limit_count"));
            upload_size    = Number.parseInt($(el).attr("data-upload_size"));
            max_upload_size    = Number.parseInt($(el).attr("data-max_upload_size"));

            // 드래그된 파일 리스트
            var files = e.originalEvent.dataTransfer.files;

            // validation
            if(files.length > 0){
                f.fn.validation(files);
                f.fn.uploadFile(el);
            }
        },
        validation:function(files){
            if(files.length>limit_count){
                alert("전송할 수 있는 최대 파일의 갯수를 초과하였습니다.");
                return false;
            }
            for (var file of files) {
                // 파일 정보
                var fileName = file.name; // 파일 명
                var fileNameArr = fileName.split("\.");
                var ext = fileNameArr[fileNameArr.length-1].toLowerCase(); // 파일 확장자

                var fileSize = file.size; // 파일 용량

                var limitExt = ["jpg","gif","png","jpeg"]; // 파일 확장자 제한
                if(limit_type === "GENERAL"){
                    limitExt = ["jpg","gif","png","jpeg","pdf","doc","docx","xlsx"];
                }else if(limit_type === "MOVIE"){
                    limitExt = ['avi','mp4','mov','mkv'];
                }

                if($.inArray(ext, limitExt) < 0){ // 확장자 체크
                    alert("등록 가능한 확장자는 "+limitExt+" 입니다.");
                    break;
                } else if (fileSize > upload_size){
                    // 파일 사이즈 체크
                    alert("업로드 가능 용량은 " + ((upload_size / 1024) / 1024) + " MB 입니다. ");
                    break;
                }else{
                    // 전체 파일 사이즈
                    totalFileSize += fileSize;

                    // 파일 배열에 넣기
                    fileList.push(file);

                    // 파일 사이즈 배열에 넣기
                    fileSizeList.push(fileSize);
                }
            }
        },
        uploadFile : function(el){
            // 파일이 있는지 체크
            if(fileList.length == 0){
                // 파일등록 경고창
                alert("파일을 선택해 주세요.");
                return false;
            }

            if(totalFileSize > max_upload_size){
                // 파일 사이즈 초과 경고창
                alert("총 업로드 가능 용량은 " + ((max_upload_size / 1024) / 1024) + " MB 입니다.");
                return false;
            }

            var form = document.createElement("form");
            var formData = new FormData(form);
            for(var file of fileList){
                if(!$.isEmptyObject(file)){
                    formData.append('files', file);
                }
            }

            $.ajax({
                url:"/util/fileUpload",
                data:formData,
                type:'POST',
                enctype:'multipart/form-data',
                processData:false,
                contentType:false,
                dataType:'json',
                cache:false,
                async:false,
                success:function(result){
                    if(result.isSuccess){
                        f.fn.uploadCallback(result.resultData);
                    } else {
                        alert("잠시 후 다시 시도하세요.");
                    }
                    fileList = new Array();
                }
            });
        },
        uploadCallback: function (files) {
            var filesIndex = 0;
            for (var data of files){
                if (data) {
                    var $parent = parents;
                    var $current = $parent;
                    if(filesIndex !== 0){
                        $parent = $parent.clone();
                    }
                    console.log(data);
                    //파일 경로
                    if(selector_input){
                        $parent.find(selector_input).val(data.previewPath);
                    }
                    //미리보기 경로 (data.previewPath+"?_noCache="+(new Date().valueOf()))
                    if(selector_preview){
                        $parent.find(selector_preview).attr("src",(data.previewPath+"?_noCache="+(new Date().valueOf())));
                    }
                    $current.after($parent);
                    filesIndex++;
                }
            }
        }
    }

    f.init = function(c){
        $(document).on('dragenter',"[data-upload_trigger='true']",function(e){f.fn.colorChange(e, this, 'url(\'../assets/img/common/no_img.png\')')});
        $(document).on('dragleave',"[data-upload_trigger='true']",function(e){f.fn.colorChange(e, this, 'url(\'../assets/img/common/no_img.png\')')});
        $(document).on('dragover',"[data-upload_trigger='true']",function(e){f.fn.colorChange(e, this, '#E3F2FC')});
        $(document).on("drop","[data-upload_trigger='true']",function(e){f.fn.dropFile(e, this)});
    }();
}();