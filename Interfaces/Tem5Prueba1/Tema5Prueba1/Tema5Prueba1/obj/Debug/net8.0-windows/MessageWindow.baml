   M S B A M L   `   `   `  ����G  CTema5Prueba1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null+clr-namespace:Tema5Prueba1Tema5Prueba1  5   	        Tema5Prueba1.MessageWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   ,localclr-namespace:Tema5Prueba1     5   	     � Title$  MessageWindow��5   	   $	��450��6   $	��700��6,   ��5	      �� 5
   
    �� 
StartPoint$	 1,0&�6    �� EndPoint$	 0,1&�6/   .��5      �  � Color$ Orange��6    � Offset$ 0Q�6*   � 5      $ Black��6   $ 1Q�6)   5      .��5      (�  (� Stretch$ Uniform=�6   .��5   
   �� $	��800��6   $	��450��6   .+�5      (  "System.Windows.Controls.DatePicker  -   5        $��	inputDate��5       �� Left$ 27��6*   
 �� Top$ 10��6;   �� 5      -   5        $��	btnSearch��5      $"��Buscar mensajes de esa fecha��6&   $	 183��6M   $��36��6_   $	��217��6k   $��Center=�6w   $	��Top=�6�   $ 4��6�   �� 5      -   5         ��Name$ cbSave��5      $��Guardar Mensajes txt��6'   $	 624��6F   $ 77��6X   �� 5      -   5        $ 	cbSavePDF��5      $��Guardar Mensajes pdf��6*   $	 624��6I   $ 55��6[   $��Center=�6k   $	��Top=�6�   �� 5      -   5        $ cbGetMessaage��5      $��Ver Mensajes��6.   $	 624��6E   $ 99��6W   $
��Left=�6g   $��Center=�6�   	 J� RenderTransformOrigin$	 0.538,0.196&�6�   �� 5      $��Usuarios que envian��6   $	 619��62   $	 138��6D   �� 5      -   5        $��
comboUsers��5      $	 627��6)   $	 166��6;   $	��120��6L   $
��Left=�6X   $	��Top=�6s   6�   �� 5      -   5        
 ��Name$
 btnSend��5      $��ENVIAR��6&   $	 646��67   $	 366��6I   $
��Left=�6Z   $	��Top=�6u   $��47��6�   $	��120��6�   6�   �� 5!      $��Mensaje��6   $ 27��6&   $	 376��67   
�������$
��Left=�6[   $	��Top=�6v   �� 5"      -   5         ��Name$ inputMessage��5"      $	 118��6,    �� TextWrapping$
 Wrap=�6>   $	 350��6S   $	��467��6d   $��78��6p   �� 5#      -	   5        $ showMessages��5#       �� 
IsReadOnly$
 True��6,   $ 27��6>   $
 Wrap=�6O   $ 49��6c   $	��558��6s   $
��Left=�6   $	��Top=�6�   $	��277��6�   5$      5%      5&      