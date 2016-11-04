" Vundle Section Begin
set nocompatible    " be iMproved, required
filetype off        " required

" set the runtime path to include Vundle and initialize
set rtp+=~/.vim/bundle/Vundle.vim
call vundle#begin()

" let Vundle manage Vundle, required
Plugin 'gmarik/Vundle.vim'

" plugins
Plugin 'moll/vim-node'
Plugin 'fatih/vim-go'
Plugin 'Shutnik/jshint2.vim'
Plugin 'Valloric/YouCompleteMe'
Plugin 'vim-ruby/vim-ruby'
" Plugin 'Raimondi/delimitMate'



" All of your plugins must be added before end
call vundle#end()   " required
filetype plugin indent on  " required

" Vundle Section End


set autoindent
set smartindent
set smarttab

set number
set ruler
set laststatus=2
set cursorline

" set search
set ignorecase
set incsearch
set hlsearch

" set mouse
set mouse=a

" set highlight
" syntax on

" set color themes
syntax enable 
colorscheme molokai
" set background=dark

" set the background transparent
hi Normal guibg=NONE ctermbg=NONE

" set tab width
set tabstop=2
set shiftwidth=2
set expandtab

" set text width
"set textwidth=120
set colorcolumn=120

" make backspace work like most other apps
set backspace=2

" python expandtab 
autocmd FileType python setlocal tabstop=2 shiftwidth=2 expandtab 

" html, ruby, javascript, json
autocmd FileType html setlocal tabstop=2 shiftwidth=2 expandtab 
autocmd FileType ruby setlocal tabstop=2 shiftwidth=2 expandtab
autocmd FileType javascript setlocal tabstop=2 shiftwidth=2 expandtab
autocmd FileType json setlocal tabstop=2 shiftwidth=2 expandtab

" tmp for java
autocmd FileType java setlocal tabstop=4 shiftwidth=4 expandtab

" gradle syntax highlight
au BufNewFile,BufRead *.gradle setf groovy

" supertab
" let g:SuperTabMappingForward = '<C-Tab>'

" latex
autocmd FileType tex setlocal makeprg=pdflatex\ --shell-escape\ '%'
map <F5> :w<CR> :!pdflatex %<<CR>

" taglist
" map <F3> :TlistToggle<CR>
" map <F4> :ts<CR>
" set tags=/Users/zhengyu/Develop/linux-3.13.7/tags

" Jshint inside vim
map <F2> :JSHint<CR>
