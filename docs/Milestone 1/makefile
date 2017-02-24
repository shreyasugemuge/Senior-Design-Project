filename=*.tex

pdf: ps
ps2pdf .ps

pdf-print: ps
ps2pdf -dColorConversionStrategy=/LeaveColorUnchanged -dPDFSETTINGS=/printer .ps

text: html
html2text -width 100 -style pretty /.html | sed -n '/./,44718p' | head -n-2 >.txt

html:
@#latex2html -split +0 -info  -no_navigation 
htlatex 

ps:dvi
dvips -t letter .dvi

dvi:
latex 
bibtex ||true
latex 
latex 

read:
evince .pdf &

aread:
acroread .pdf

clean:
rm -f .{ps,pdf,log,aux,out,dvi,bbl,blg}

