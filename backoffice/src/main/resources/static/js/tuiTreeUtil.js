(function($){
    $.tuiTreeUtil = {
        init:function(target, nodeDefaultState, title, treeData, isCheckbox){
            /*********************************************
             * @param target : 트리 생성 타켓 div id
             * @param nodeDefaultState : 하위 노드 오픈 여부
             * @param title : 노드 이름으로 사용할 컬럼
             * @param treeData : 트리 데이터
             * @param isCheckbox : true or false
             *********************************************/

            // 하위 노드 오픈 여부
            var state = 'closed';
            if(nodeDefaultState){
                state = nodeDefaultState;
            }
            // 노드 이름으로 사용할 컬럼
            var text = 'text';
            if(title){
                text = title;
            }

            // 기본 템플릿
            var template = {
                internalNode:
                    '<div class="tui-tree-content-wrapper">' +
                        '<button type="button" class="tui-tree-toggle-btn tui-js-tree-toggle-btn">' +
                            '<span class="tui-ico-tree"></span>' +
                            '{{stateLabel}}' +
                        '</button>' +
                        '<span class="tui-tree-text tui-js-tree-text">' +
                            '<span class="tui-tree-ico tui-ico-folder"></span>' +
                            '{{'+text+'}}' +
                        '</span>' +
                    '</div>' +
                    '<ul class="tui-tree-subtree tui-js-tree-subtree">' +
                        '{{children}}' +
                    '</ul>',
                leafNode:
                    '<div class="tui-tree-content-wrapper">' +
                        '<span class="tui-tree-text tui-js-tree-text">' +
                            '<span class="tui-tree-ico tui-ico-file"></span>' +
                            '{{'+text+'}}' +
                        '</span>' +
                    '</div>'
            }

            // checkbox 템플릿
            if(isCheckbox){
                template = {
                    internalNode:
                        '<div class="tui-tree-content-wrapper" style="padding-left: {{indent}}px">' +
                            '<button type="button" class="tui-tree-toggle-btn tui-js-tree-toggle-btn">' +
                                '<span class="tui-ico-tree"></span>' +
                                '{{stateLabel}}' +
                            '</button>' +
                            '<span class="tui-tree-text tui-js-tree-text">' +
                                '<label class="tui-checkbox">' +
                                    '<span class="tui-ico-check"><input type="checkbox" class="tui-tree-checkbox"></span>' +
                                '</label>' +
                                '<span class="tui-tree-ico tui-ico-folder"></span>' +
                                '{{'+text+'}}' +
                            '</span>' +
                        '</div>' +
                        '<ul class="tui-tree-subtree tui-js-tree-subtree">{{children}}</ul>',
                    leafNode:
                        '<div class="tui-tree-content-wrapper" style="padding-left: {{indent}}px">' +
                            '<span class="tui-tree-text tui-js-tree-text">' +
                                '<label class="tui-checkbox">' +
                                    '<span class="tui-ico-check"><input type="checkbox" class="tui-tree-checkbox"></span>' +
                                '</label>' +
                                '<span class="tui-tree-ico tui-ico-file"></span>' +
                                '{{'+text+'}}' +
                            '</span>' +
                        '</div>'
                }
            }

            // 트리 생성
            this.tree.target = new tui.Tree(target, {
                data: treeData,
                nodeDefaultState: state,
                template: template
            });

            // select or checkbox
            if (isCheckbox){
                this.tree.target.enableFeature('Checkbox', {
                    checkboxClassName: 'tui-tree-checkbox',
                });
            } else {
                this.tree.target.enableFeature('Selectable');
            }

            // 첫번째 depth open
            this.tree.target.open('tui-tree-node-1');

            return $.extend(true,{},this.tree);
        },
        tree : {
            target : null,
            // 체크된 모든 노드 리스트 추출
            getCheckedNodeList:function(){
                var _this = this.target;
                var result = [];
                _this.getCheckedList().forEach(function(item){
                    result.push(_this.getNodeData(item));
                });
                return result;
            }
            // todo tree function 커스터마이징 예정
        }
    }
})(jQuery);