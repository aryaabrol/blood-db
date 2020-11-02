from PyPDF2 import PdfFileReader, PdfFileWriter
 
file_path = '/Users/Vishwajeet/Desktop/bloodtest.pdf'
pdf = PdfFileReader(file_path)
with open('bloodreport.txt', 'w') as f:
    for page_num in range(pdf.numPages):
        print('Page: {0}'.format(page_num))
        pageObj = pdf.getPage(page_num)
 
        try: 
            txt = pageObj.extractText()
            #print(''.center(100, '-'))
            print(txt+" ")
        except:
            pass
        else:
            f.write('Page {0}\n'.format(page_num+1))
            f.write(''.center(100, '-'))
            f.write(txt)
    f.close()
