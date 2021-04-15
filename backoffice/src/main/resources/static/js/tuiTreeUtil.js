(function($){
    $.tuiTreeUtil = {
        init:function(target, nodeDefaultState, title, root_node, tree_node, isCheckbox){
            /*********************************************
             * @param target : 트리 생성 타켓 div id
             * @param nodeDefaultState : 하위 노드 오픈 여부
             * @param title : 노드 이름으로 사용할 컬럼
             * @param root_node : 트리 root 데이터
             * @param tree_node : 트리 데이터
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
            var template = this.tree.defaultTemplate(text);

            // checkbox 템플릿
            if(typeof isCheckbox === 'boolean' && isCheckbox){
                template = this.tree.checkboxTemplate(text);
            }

            var treeData = null;
            // root_node
            if(root_node){
                treeData = root_node; // root setting
                treeData[0].children = tree_node;
            } else {
                treeData = tree_node;
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
            // this.tree.target.open('tui-tree-node-1');

            return $.extend(true,{},this.tree);
        },
        tree : {
            target : null,
            // 기본 템플릿
            defaultTemplate : function(text){
                return {
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
            },
            // 체크박스 템플릿
            checkboxTemplate : function(text){
                return {
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
            },
            // 체크된 모든 노드 리스트 추출
            getCheckedNodeList : function(){
                var _this = this.target;
                var result = [];
                _this.getCheckedList().forEach(function(item){
                    result.push(_this.getNodeData(item));
                });
                return result;
            },
            onSelect : function(f){
                this.target.on('select', f);
                return this;
            },
            select : function(nodeId){
                this.target.select(nodeId);
                return this;
            },
            open : function(nodeId, recursive){
                this.target.open(nodeId, recursive);
                return this;
            },
            getNodeData:function(nodeId){
                return this.target.getNodeData(nodeId);
            }
        }
    }
})(jQuery);