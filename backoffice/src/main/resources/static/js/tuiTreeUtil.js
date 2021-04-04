(function($){
    $.tuiTreeUtil = {
        init:function(target, nodeDefaultState, enableFeature, data, title){
            this.tree.target = new tui.Tree(target, {
                data: data,
                nodeDefaultState: nodeDefaultState,
                stateLabels: { opened: '-', closed: '+' },
                template: {
                    internalNode:
                        '<div class="tui-tree-content-wrapper">' +
                            '<button type="button" class="tui-tree-toggle-btn tui-js-tree-toggle-btn">' +
                                '<span class="tui-ico-tree"></span>' +
                                '{{stateLabel}}' +
                            '</button>' +
                            '<span class="tui-tree-text tui-js-tree-text">' +
                                '<span class="tui-tree-ico tui-ico-folder"></span>' +
                                '{{'+title+'}}' +
                            '</span>' +
                        '</div>' +
                        '<ul class="tui-tree-subtree tui-js-tree-subtree">' +
                            '{{children}}' +
                        '</ul>',
                    leafNode:
                        '<div class="tui-tree-content-wrapper">' +
                            '<span class="tui-tree-text tui-js-tree-text">' +
                                '<span class="tui-tree-ico tui-ico-file"></span>' +
                                '{{'+title+'}}' +
                            '</span>' +
                        '</div>'
                }
            }).enableFeature('Selectable', {
                selectedClassName: 'tui-tree-selected',
            });
        },
        tree:{
            target:null
        }
    }
})(jQuery);